package cn.cisdom.base.api;

import cn.cisdom.base.annotation.IgnoreAuth;
import cn.cisdom.base.annotation.LoginUser;
import cn.cisdom.base.entity.PasswdrcEntity;
import cn.cisdom.base.entity.UserEntity;
import cn.cisdom.base.entity.VerifycodeEntity;
import cn.cisdom.base.service.*;
import cn.cisdom.base.utils.R;
import cn.cisdom.base.utils.RRException;
import cn.cisdom.base.utils.ShiroUtils;
import cn.cisdom.base.validator.Assert;
import com.google.code.kaptcha.Constants;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 用户
 *
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-07-11 16:04:48
 */
@Api(description = "用户相关的接口")
@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private CaptchaService captchaService;
    @Autowired
    private UserService userService;
    @Autowired
    private TokenService tokenService;
    @Autowired
    private VerifycodeService codeService;
    @Autowired
    private PasswdrcService pwdService;

//	/**
//	 * 列表
//	 */
//	@RequestMapping("/list")
//	@RequiresPermissions("user:list")
//	public R list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//
//		List<UserEntity> userList = userService.queryList(query);
//		int total = userService.queryTotal(query);
//
//		PageUtils pageUtil = new PageUtils(userList, total, query.getLimit(), query.getPage());
//
//		return R.ok().put("page", pageUtil);
//	}
//
//
//	/**
//	 * 信息
//	 */
//	@RequestMapping("/info/{userId}")
////	@RequiresPermissions("user:info")
//	public R info(@PathVariable("userId") Long userId){
//		UserEntity user = userService.queryObject(userId);
//
//		return R.ok().put("user", user);
//	}
//
//	/**
//	 * 保存
//	 */
//	@RequestMapping("/save")
//	@RequiresPermissions("user:save")
//	public R save(@RequestBody UserEntity user){
//		userService.save(user);
//
//		return R.ok();
//	}
//
//	/**
//	 * 修改
//	 */
//	@RequestMapping("/update")
//	@RequiresPermissions("user:update")
//	public R update(@RequestBody UserEntity user){
//		userService.update(user);
//
//		return R.ok();
//	}
//
//	/**
//	 * 删除
//	 */
//	@RequestMapping("/delete")
//	@RequiresPermissions("user:delete")
//	public R delete(@RequestBody Long[] userIds){
//		userService.deleteBatch(userIds);
//
//		return R.ok();
//	}

    /**
     * 登录
     */
    @IgnoreAuth
    @PostMapping("login")
    @ApiOperation(notes = "用户登录", value = "用户登录", httpMethod = "POST")
    public R login(String mobile, String password) {
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");
//        String kaptcha = ShiroUtils.getKaptcha(Constants.KAPTCHA_SESSION_KEY);
//        if(!captcha.equalsIgnoreCase(kaptcha)){
//            return R.error("验证码不正确");
//        }
        //用户登录
        String userId = userService.login(mobile, password);
        UserEntity user = userService.queryObject(userId);

        Map<String, Object> result = new HashMap<>();
        if (user.getStatus() != 0) {
            return R.error("您的账号已被冻结，请联系管理员");
        }
        //生成token
        Map<String, Object> map = tokenService.createToken(userId);
        map.put("user", userService.queryObject(userId));
        result.put("data", map);
        result.put("msg", "成功");

        return R.ok(result);
    }

    /**
     * 注册
     */
    @IgnoreAuth
    @PostMapping("regist")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "password", value = "密码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "验证码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "userName", value = "用户名", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(notes = "用户注册", value = "用户注册", httpMethod = "POST")
    public R regist(String mobile, String password, String code) {
        Assert.isBlank(mobile, "手机号不能为空");
        Assert.isBlank(password, "密码不能为空");

        String userId = userService.register(mobile, password, code);

        //生成token
        Map<String, Object> map = tokenService.createToken(userId);
        Map<String, Object> result = new HashMap<>();
        map.put("user", userService.queryObject(userId));
        result.put("data", map);
        result.put("msg", "成功");

        return R.ok(result);
    }

    /**
     * 修改密码
     */
    @PostMapping("changePwd")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "oriPwd", value = "原始密码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(notes = "修改密码", value = "修改密码", httpMethod = "POST")
    public R changePwd(@LoginUser UserEntity user, @RequestParam @ApiIgnore Map<String, Object> params) {
        Assert.isValid(new Object[]{params.get("oriPwd"),params.get("newPwd")});
        final String oriPwd = params.get("oriPwd").toString();
        final String newPwd = params.get("newPwd").toString();
        final String mobile = user.getMobile();
        final UserEntity server = userService.queryByMobile(mobile);

        if (!oriPwd.equals(server.getPassword())) {
            return R.error("原始密码不正确");
        }
        server.setPassword(newPwd);
        userService.update(server);
        Map<String, Object> result = new HashedMap();
        result.put("data", "");
        result.put("msg", "成功");
        return R.ok(result);
    }

    /**
     * 修改用户信息
     */
    @PostMapping("updateUserInfo")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "name", value = "姓名", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "address", value = "地址", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qq", value = "QQ号", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(notes = "修改用户信息", value = "修改用户信息", httpMethod = "POST")
    public R updateUserInfo(@LoginUser UserEntity user, @RequestParam @ApiIgnore Map<String, Object> params) {
        Assert.isValid(new Object[]{params.get("name"),params.get("address"),params.get("qq"),params.get("email")});
        final String userName = params.get("name").toString().trim();
        final String address = params.get("address").toString().trim();
        final String qq = params.get("qq").toString().trim();
        final String email = params.get("email").toString().trim();
        final String mobile = user.getMobile();
        final UserEntity server = userService.queryByMobile(mobile);
        server.setUserName(userName);
        server.setAddress(address);
        server.setQq(qq);
        server.setEmail(email);
        userService.update(server);
        Map<String, Object> result = new HashedMap();
        result.put("data", server);
        result.put("msg", "成功");
        return R.ok(result);
    }

    /**
     * 找回密码
     */
    @IgnoreAuth
    @PostMapping("findPwd")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "mobile", value = "手机号码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "newPwd", value = "新密码", required = true, dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "code", value = "短信验证码", required = true, dataType = "string", paramType = "query")
    })
    @ApiOperation(notes = "找回密码", value = "找回密码", httpMethod = "POST")
    public R findPwd(@RequestParam @ApiIgnore Map<String, Object> params) {
        Assert.isValid(new Object[]{params.get("mobile"),params.get("code"),params.get("newPwd")});
        final String mobile = params.get("mobile").toString().trim();
        final String code = params.get("code").toString().trim();
        final UserEntity server = userService.queryByMobile(mobile);
        if (null == server) {
            return R.error("用户不存在");
        }

        Map<String, Object> query = new HashedMap();
        query.put("mobile", mobile);
        query.put("type", String.valueOf(3));
        query.put("status", String.valueOf(0));
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
                throw new RRException("请输入正确的验证码");
            }
        }

        final String newPwd = params.get("newPwd").toString().trim();
        server.setPassword(newPwd);
        userService.update(server);
        Map<String, Object> result = new HashedMap();
        result.put("data", "");
        result.put("msg", "成功");
        return R.ok(result);
    }

}
