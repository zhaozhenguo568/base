package cn.cisdom.base.service;

import cn.cisdom.base.entity.ModelModuleEntity;

import java.util.List;
import java.util.Map;

/**
 * 模板模块信息表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-15 11:10:27
 */
public interface ModelModuleService {
	
	ModelModuleEntity queryObject(Integer id);
	
	List<ModelModuleEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ModelModuleEntity modelModule);
	
	void update(ModelModuleEntity modelModule);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
