package cn.cisdom.base.api;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.validator.Assert;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.cisdom.base.entity.ModelModuleEntity;
import cn.cisdom.base.service.ModelModuleService;
import cn.cisdom.base.utils.R;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 模板模块信息表
 *
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-15 11:10:27
 */
@Api(description = "模块相关的接口")
@RestController
@RequestMapping("/api/module")
public class ModuleController {
    @Autowired
    private ModelModuleService modelModuleService;

    /**
     * 获取模板栏目列表
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户模板ID", required = true, dataType = "int", paramType = "query"),
    })
    @PostMapping("/list")
    @ApiOperation(notes = "获取模板栏目列表", value = "获取模板栏目列表", httpMethod = "POST")
    public R list(@RequestParam @ApiIgnore Map<String, Object> params) {
        List<ModelModuleEntity> modelModuleList = modelModuleService.queryList(params);
        Map<String, Object> result = new HashedMap();
        result.put("data", modelModuleList);
        result.put("msg", "成功");

        return R.ok(result);
    }

    /**
     * 编辑模板栏目
     */
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "用户模板ID", required = true, dataType = "int", paramType = "query"),
            @ApiImplicitParam(name = "title", value = "标题", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "subTitle", value = "子标题", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "mobilePic", value = "手机图片", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "pcPic", value = "PC图片", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "isShow", value = "是否隐藏", dataType = "string", paramType = "query"),
            @ApiImplicitParam(name = "openType", value = "打开方式(0当前页 1标签页)", dataType = "int", paramType = "query")
    })
    @PostMapping("/update")
    @ApiOperation(notes = "编辑模板栏目", value = "编辑模板栏目", httpMethod = "POST")
    public R updateModule(@RequestParam @ApiIgnore Map<String, Object> params) {
        Assert.isValid(params.get("id"));
        final int id = Integer.parseInt(params.get("id").toString().trim());
        final ModelModuleEntity entity = modelModuleService.queryObject(id);
        if (null != params.get("title")) {
            final String title = params.get("title").toString();
            entity.setTitle(title);
        }
        if (null != params.get("subTitle")) {
            final String subTitle = params.get("subTitle").toString();
            entity.setSubtitle(subTitle);
        }
        if (null != params.get("mobilePic")) {
            final String mobilePic = params.get("mobilePic").toString();
            entity.setMPic(mobilePic);
        }
        if (null != params.get("pcPic")) {
            final String pcPic = params.get("pcPic").toString();
            entity.setPcPic(pcPic);
        }
        if (null != params.get("openType")) {
            final String openType = params.get("openType").toString().trim();
            entity.setOpenType(openType);
        }
        if (null != params.get("isShow")) {
            final String isShow = params.get("isShow").toString().trim();
            entity.setIndexShow(isShow);
        }
        modelModuleService.update(entity);
        Map<String, Object> result = new HashedMap();
        result.put("data", "");
        result.put("msg", "成功");

        return R.ok(result);
    }


//	/**
//	 * 信息
//	 */
//	@RequestMapping("/info/{id}")
//	@RequiresPermissions("modelmodule:info")
//	public R info(@PathVariable("id") Integer id){
//		ModelModuleEntity modelModule = modelModuleService.queryObject(id);
//
//		return R.ok().put("modelModule", modelModule);
//	}
//
//	/**
//	 * 保存
//	 */
//	@RequestMapping("/save")
//	@RequiresPermissions("modelmodule:save")
//	public R save(@RequestBody ModelModuleEntity modelModule){
//		modelModuleService.save(modelModule);
//
//		return R.ok();
//	}
//
//	/**
//	 * 修改
//	 */
//	@RequestMapping("/update")
//	@RequiresPermissions("modelmodule:update")
//	public R update(@RequestBody ModelModuleEntity modelModule){
//		modelModuleService.update(modelModule);
//
//		return R.ok();
//	}
//
//	/**
//	 * 删除
//	 */
//	@RequestMapping("/delete")
//	@RequiresPermissions("modelmodule:delete")
//	public R delete(@RequestBody Integer[] ids){
//		modelModuleService.deleteBatch(ids);
//
//		return R.ok();
//	}

}
