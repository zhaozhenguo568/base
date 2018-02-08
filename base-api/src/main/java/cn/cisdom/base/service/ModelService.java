package cn.cisdom.base.service;

import cn.cisdom.base.entity.ModelEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户模板表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-08 16:41:48
 */
public interface ModelService {
	
	ModelEntity queryObject(Integer id);
	
	List<ModelEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ModelEntity model);
	
	void update(ModelEntity model);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
