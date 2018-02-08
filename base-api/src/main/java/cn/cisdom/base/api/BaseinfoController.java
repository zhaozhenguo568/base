package cn.cisdom.base.api;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.validator.Assert;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import org.apache.commons.collections.map.HashedMap;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.cisdom.base.entity.BaseinfoEntity;
import cn.cisdom.base.service.BaseinfoService;
import cn.cisdom.base.utils.PageUtils;
import cn.cisdom.base.utils.Query;
import cn.cisdom.base.utils.R;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 网站基础信息表
 *
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-18 15:05:07
 */
@RestController
@RequestMapping("/api/baseinfo")
public class BaseinfoController {
    @Autowired
    private BaseinfoService baseinfoService;

//	/**
//	 * 列表
//	 */
//	@RequestMapping("/list")
//	@RequiresPermissions("baseinfo:list")
//	public R list(@RequestParam Map<String, Object> params){
//		//查询列表数据
//        Query query = new Query(params);
//
//		List<BaseinfoEntity> baseinfoList = baseinfoService.queryList(query);
//		int total = baseinfoService.queryTotal(query);
//
//		PageUtils pageUtil = new PageUtils(baseinfoList, total, query.getLimit(), query.getPage());
//
//		return R.ok().put("page", pageUtil);
//	}
//
//
//	/**
//	 * 信息
//	 */
//	@RequestMapping("/info/{id}")
//	@RequiresPermissions("baseinfo:info")
//	public R info(@PathVariable("id") Integer id){
//		BaseinfoEntity baseinfo = baseinfoService.queryObject(id);
//
//		return R.ok().put("baseinfo", baseinfo);
//	}
//
//	/**
//	 * 保存
//	 */
//	@RequestMapping("/save")
//	@RequiresPermissions("baseinfo:save")
//	public R save(@RequestBody BaseinfoEntity baseinfo){
//		baseinfoService.save(baseinfo);
//
//		return R.ok();
//	}

    /**
     * 编辑网站基本信息
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户模板ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "标题", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "logo", value = "logo", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "contact", value = "联系人，多个用逗号隔开", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "email", value = "E-Mail", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "address", value = "地址", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "qrcode", value = "二维码", dataType = "string", paramType = "query")
    })
    @RequestMapping("/update")
    public R update(@RequestParam @ApiIgnore Map<String, Object> params) {
        Assert.isValid(params.get("id"));

        final int id = Integer.parseInt(params.get("id").toString().trim());
        final BaseinfoEntity baseinfo = baseinfoService.queryObject(id);
        if (null != params.get("title")) {
            final String title = params.get("title").toString();
            baseinfo.setTitle(title);
        }
        if (null != params.get("logo")) {
            final String logo = params.get("logo").toString();
            baseinfo.setLogoPic(logo);
        }
        if (null != params.get("contact")) {
            final String contact = params.get("contact").toString();
            baseinfo.setContactPhone(contact);
        }
        if (null != params.get("email")) {
            final String email = params.get("email").toString();
            baseinfo.setEmail(email);
        }
        if (null != params.get("address")) {
            final String address = params.get("address").toString();
            baseinfo.setAddress(address);
        }
        if (null != params.get("qrcode")) {
            final String qrcode = params.get("qrcode").toString();
            baseinfo.setQrcode(qrcode);
        }
        baseinfoService.update(baseinfo);

        Map<String, Object> result = new HashedMap();
        result.put("data", "");
        result.put("msg", "成功");

        return R.ok(result);
    }

//	/**
//	 * 删除
//	 */
//	@RequestMapping("/delete")
//	@RequiresPermissions("baseinfo:delete")
//	public R delete(@RequestBody Integer[] ids){
//		baseinfoService.deleteBatch(ids);
//
//		return R.ok();
//	}

}
