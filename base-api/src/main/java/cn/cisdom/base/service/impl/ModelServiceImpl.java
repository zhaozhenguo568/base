package cn.cisdom.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.dao.ModelDao;
import cn.cisdom.base.entity.ModelEntity;
import cn.cisdom.base.service.ModelService;



@Service("modelService")
public class ModelServiceImpl implements ModelService {
	@Autowired
	private ModelDao modelDao;
	
	@Override
	public ModelEntity queryObject(Integer id){
		return modelDao.queryObject(id);
	}
	
	@Override
	public List<ModelEntity> queryList(Map<String, Object> map){
		return modelDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return modelDao.queryTotal(map);
	}
	
	@Override
	public void save(ModelEntity model){
		modelDao.save(model);
	}
	
	@Override
	public void update(ModelEntity model){
		modelDao.update(model);
	}
	
	@Override
	public void delete(Integer id){
		modelDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		modelDao.deleteBatch(ids);
	}
	
}
