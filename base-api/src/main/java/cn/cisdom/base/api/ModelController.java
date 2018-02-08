package cn.cisdom.base.api;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.annotation.LoginUser;
import cn.cisdom.base.entity.UserEntity;
import cn.cisdom.base.utils.PageUtils;
import cn.cisdom.base.utils.Query;
import cn.cisdom.base.utils.R;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.cisdom.base.entity.ModelEntity;
import cn.cisdom.base.service.ModelService;
import springfox.documentation.annotations.ApiIgnore;


/**
 * 用户模板表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-08 16:41:48
 */
@Api(description = "模板相关的接口")
@RestController
@RequestMapping("/api/model")
public class ModelController {

	@Autowired
	private ModelService modelService;
	
	/**
	 * 列表
	 */
	@ApiImplicitParams({
			@ApiImplicitParam(name = "status", value = "类型(不填为全部,1为已过期,2为即将过期)", dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int", paramType = "query"),
			@ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "int", paramType = "query")
	})
	@ApiOperation(notes = "模板列表", value = "模板列表", httpMethod = "POST")
	@PostMapping("list")
	public R list(@LoginUser UserEntity user, @RequestParam @ApiIgnore Map<String, Object> params){
		//查询列表数据
		params.put("userId",user.getId());
        Query query = new Query(params);
		List<ModelEntity> modelList = modelService.queryList(query);
		PageUtils pageUtils = new PageUtils(modelList, query.getLimit(), query.getPage());
		Map<String, Object> result = new HashedMap();
		result.put("data", pageUtils.getList());
		result.put("msg", "成功");

		return R.ok(result);
	}


//	/**
//	 * 信息
//	 */
//	@RequestMapping("/info/{id}")
//	@RequiresPermissions("model:info")
//	public R info(@PathVariable("id") Integer id){
//		ModelEntity model = modelService.queryObject(id);
//
//		return R.ok().put("model", model);
//	}
//
//	/**
//	 * 保存
//	 */
//	@RequestMapping("/save")
//	@RequiresPermissions("model:save")
//	public R save(@RequestBody ModelEntity model){
//		modelService.save(model);
//
//		return R.ok();
//	}
//
//	/**
//	 * 修改
//	 */
//	@RequestMapping("/update")
//	@RequiresPermissions("model:update")
//	public R update(@RequestBody ModelEntity model){
//		modelService.update(model);
//
//		return R.ok();
//	}
//
//	/**
//	 * 删除
//	 */
//	@RequestMapping("/delete")
//	@RequiresPermissions("model:delete")
//	public R delete(@RequestBody Integer[] ids){
//		modelService.deleteBatch(ids);
//
//		return R.ok();
//	}

//	/**
//	 * 模板列表
//	 */
//	@ApiImplicitParams({
//			@ApiImplicitParam(name = "page", value = "页数", required = true, dataType = "int", paramType = "query"),
//			@ApiImplicitParam(name = "limit", value = "每页数量", required = true, dataType = "int", paramType = "query")
//	})
//	@ApiOperation(notes = "模板列表", value = "模板列表", httpMethod = "POST")
//	@PostMapping("list")
//	public R list(@LoginUser UserEntity user, @RequestParam @ApiIgnore Map<String, Object> params) {
//		Query query = new Query(params);
//		List<ModelEntity> list = modelService.queryList(query);
//		PageUtils pageUtils = new PageUtils(list, query.getLimit(), query.getPage());
//		Map<String, Object> result = new HashedMap();
//		result.put("data", pageUtils.getList());
//		result.put("msg", "成功");
//
//		return R.ok(result);
//	}
	
}
