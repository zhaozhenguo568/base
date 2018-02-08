package cn.cisdom.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.dao.ModuleTypeDao;
import cn.cisdom.base.entity.ModuleTypeEntity;
import cn.cisdom.base.service.ModuleTypeService;



@Service("moduleTypeService")
public class ModuleTypeServiceImpl implements ModuleTypeService {
	@Autowired
	private ModuleTypeDao moduleTypeDao;
	
	@Override
	public ModuleTypeEntity queryObject(Integer id){
		return moduleTypeDao.queryObject(id);
	}
	
	@Override
	public List<ModuleTypeEntity> queryList(Map<String, Object> map){
		return moduleTypeDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return moduleTypeDao.queryTotal(map);
	}
	
	@Override
	public void save(ModuleTypeEntity moduleType){
		moduleTypeDao.save(moduleType);
	}
	
	@Override
	public void update(ModuleTypeEntity moduleType){
		moduleTypeDao.update(moduleType);
	}
	
	@Override
	public void delete(Integer id){
		moduleTypeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		moduleTypeDao.deleteBatch(ids);
	}
	
}
