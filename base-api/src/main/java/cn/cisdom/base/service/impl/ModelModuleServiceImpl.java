package cn.cisdom.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.dao.ModelModuleDao;
import cn.cisdom.base.entity.ModelModuleEntity;
import cn.cisdom.base.service.ModelModuleService;



@Service("modelModuleService")
public class ModelModuleServiceImpl implements ModelModuleService {
	@Autowired
	private ModelModuleDao modelModuleDao;
	
	@Override
	public ModelModuleEntity queryObject(Integer id){
		return modelModuleDao.queryObject(id);
	}
	
	@Override
	public List<ModelModuleEntity> queryList(Map<String, Object> map){
		return modelModuleDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return modelModuleDao.queryTotal(map);
	}
	
	@Override
	public void save(ModelModuleEntity modelModule){
		modelModuleDao.save(modelModule);
	}
	
	@Override
	public void update(ModelModuleEntity modelModule){
		modelModuleDao.update(modelModule);
	}
	
	@Override
	public void delete(Integer id){
		modelModuleDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		modelModuleDao.deleteBatch(ids);
	}
	
}
