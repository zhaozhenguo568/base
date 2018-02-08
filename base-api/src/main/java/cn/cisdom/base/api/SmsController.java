package cn.cisdom.base.api;

import cn.cisdom.base.annotation.IgnoreAuth;
import cn.cisdom.base.entity.CaptchaEntity;
import cn.cisdom.base.entity.UserEntity;
import cn.cisdom.base.entity.VerifycodeEntity;
import cn.cisdom.base.service.CaptchaService;
import cn.cisdom.base.service.UserService;
import cn.cisdom.base.service.VerifycodeService;
import cn.cisdom.base.sms.utils.SmsUtils;
import cn.cisdom.base.utils.IPUtils;
import cn.cisdom.base.utils.R;
import cn.cisdom.base.utils.RRException;
import cn.cisdom.base.validator.Assert;
import com.google.code.kaptcha.Producer;
import io.swagger.annotations.*;
import org.apache.commons.collections.map.HashedMap;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import springfox.documentation.annotations.ApiIgnore;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;


/**
 * 短信验证码
 *
 * @author zhenglee
 */
@Api(description = "短信相关的接口")
@RestController
@RequestMapping("/api/sms")
public class SmsController {

    //10分钟有效
    private static final long EXPIRE_TIME = 1000 * 60 * 10;
    //1分钟发送间隔
    private static final long INTERVAL_TIME = 1000 * 60;

    @Autowired
    private Producer producer;
    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private VerifycodeService codeService;

    @Autowired
    private UserService userService;

    @IgnoreAuth
    @GetMapping("captcha.jpg")
    @ApiOperation(notes = "请求验证码图片", value = "请求验证码图片", httpMethod = "GET")
    public void captcha(HttpServletResponse response) throws ServletException, IOException {
        response.setHeader("Cache-Control", "no-store, no-cache");
        response.setContentType("image/jpeg");

        //生成文字验证码
        String text = producer.createText();
        final CaptchaEntity captcha = new CaptchaEntity();
        captcha.setCaptcha(text);
        captcha.setCreateTime(new Date());
        captchaService.save(captcha);
        //生成图片验证码
        BufferedImage image = producer.createImage(text);

        ServletOutputStream out = response.getOutputStream();
        ImageIO.write(image, "jpg", out);
        IOUtils.closeQuietly(out);
    }

    /**
     * 发送注册验证码
     */
    @Transactional
    @IgnoreAuth
    @PostMapping("sendRegister")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "captcha", value = "图形验证码", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(notes = "发送注册验证码", value = "发送注册验证码", httpMethod = "POST")
    public R sendRegister(@RequestParam @ApiIgnore Map<String, Object> params, @ApiIgnore HttpServletRequest request) {
        final String captcha = params.get("captcha").toString();
        final boolean exist = (captchaService.exists(captcha)) == 1 ? true : false;
        if (!exist) {
            return R.error("图形验证码不正确");
        }
        captchaService.deleteByCaptcha(captcha);
        final String mobile = params.get("mobile").toString();
        UserEntity user = userService.queryByMobile(mobile);
        if (null != user) {
            return R.error("用户已经注册，请登录");
        }
        final String codeStr = String.valueOf(SmsUtils.generateSmsCode());

        if (!SmsUtils.messageXSend(mobile, codeStr)) {
            return R.error("验证码发送失败");
        }
        final String ip = IPUtils.getIpAddr(request);
        System.out.println("IP:      " + ip);
        saveCode(mobile, codeStr, String.valueOf(1), ip);

        final Map<String, Object> result = new HashedMap();
        result.put("data", "");
        result.put("msg", "成功");
        return R.ok(result);
    }

    /**
     * 发送验证码(非注册的时候)
     */
    @Transactional
    @IgnoreAuth
    @PostMapping("sendCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "captcha", value = "图形验证码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "验证类型(2为找回密码，3为修改手机号)", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(notes = "发送验证码", value = "发送验证码", httpMethod = "POST")
    public R sendCode(@RequestParam @ApiIgnore Map<String, Object> params, @ApiIgnore HttpServletRequest request) {
        Assert.isValid(new Object[]{params.get("captcha"), params.get("mobile"), params.get("type")});
        final String captcha = params.get("captcha").toString();
        final boolean exist = (captchaService.exists(captcha)) == 1 ? true : false;
        if (!exist) {
            return R.error("图形验证码不正确");
        }
        captchaService.deleteByCaptcha(captcha);
        final String mobile = params.get("mobile").toString();
        final UserEntity user = userService.queryByMobile(mobile);
        if (null == user) {
            return R.error("用户未注册，请先注册");
        }

        final String type = params.get("type").toString();
        Map<String, Object> query = new HashedMap();
        query.put("mobile", mobile);
        query.put("type", type);
        List<VerifycodeEntity> validCodes = codeService.queryValidList(query);
        if (!validCodes.isEmpty()) {
            return R.error("您的操作太频繁了，请稍后再试");
        }

        final String codeStr = String.valueOf(SmsUtils.generateSmsCode());

        if (!SmsUtils.messageXSend(mobile, codeStr)) {
            return R.error("验证码发送失败");
        }
        saveCode(mobile, codeStr, type, IPUtils.getIpAddr(request));

        final Map<String, Object> result = new HashedMap();
        result.put("data", "");
        result.put("msg", "成功");
        return R.ok(result);
    }

    /**
     * 验证验证码(非注册的时候)
     */
    @IgnoreAuth
    @PostMapping("vertifyCode")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "type", value = "验证类型(2为找回密码，3为修改手机号)", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(notes = "验证验证码", value = "验证验证码", httpMethod = "POST")
    public R vertifyCode(@RequestParam @ApiIgnore Map<String, Object> params) {
        Assert.isValid(new Object[]{params.get("type"), params.get("mobile"), params.get("code")});
        final String type = params.get("type").toString().trim();
        final String mobile = params.get("mobile").toString().trim();
        final String code = params.get("code").toString().trim();
        Map<String, Object> query = new HashedMap();
        query.put("mobile", mobile);
        query.put("type", type);
        List<VerifycodeEntity> codes = codeService.queryValidList(query);
        if (null == codes || codes.isEmpty()) {
            throw new RRException("请输入正确的验证码");
        }
        for (VerifycodeEntity entity : codes) {
            if (entity.getCode().equalsIgnoreCase(code)) {
                if (new Date().after(entity.getExpireTime())) {
                    return R.error("验证码已过期");
                } else {
                    final VerifycodeEntity vc = entity;
                    vc.setStatus(String.valueOf(1));
                    codeService.update(vc);
                    break;
                }
            } else {
                return R.error("请输入正确的验证码");
            }
        }
        final Map<String, Object> result = new HashedMap();
        result.put("data", "");
        result.put("msg", "成功");
        return R.ok(result);
    }

    private void saveCode(String mobile, String codeStr, String type, String ip) {
        final UserEntity user = userService.queryByMobile(mobile);
        final VerifycodeEntity code = new VerifycodeEntity();
        final long now = System.currentTimeMillis();
        code.setMobile(mobile);
        code.setCode(codeStr);
        code.setSendTime(new Date(now));
        code.setType(type);
        code.setIp(ip);
        code.setStatus(String.valueOf(0));
        code.setExpireTime(new Date(now + EXPIRE_TIME));
        if (null != user) {
            code.setUserId(user.getId());
        }
        codeService.save(code);
    }

}
