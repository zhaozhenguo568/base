package cn.cisdom.base.service;

import cn.cisdom.base.entity.ModuleTypeEntity;

import java.util.List;
import java.util.Map;

/**
 * 栏目类型表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-15 13:36:57
 */
public interface ModuleTypeService {
	
	ModuleTypeEntity queryObject(Integer id);
	
	List<ModuleTypeEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(ModuleTypeEntity moduleType);
	
	void update(ModuleTypeEntity moduleType);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
