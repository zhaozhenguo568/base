package cn.cisdom.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.dao.BaseinfoDao;
import cn.cisdom.base.entity.BaseinfoEntity;
import cn.cisdom.base.service.BaseinfoService;



@Service("baseinfoService")
public class BaseinfoServiceImpl implements BaseinfoService {
	@Autowired
	private BaseinfoDao baseinfoDao;
	
	@Override
	public BaseinfoEntity queryObject(Integer id){
		return baseinfoDao.queryObject(id);
	}
	
	@Override
	public List<BaseinfoEntity> queryList(Map<String, Object> map){
		return baseinfoDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return baseinfoDao.queryTotal(map);
	}
	
	@Override
	public void save(BaseinfoEntity baseinfo){
		baseinfoDao.save(baseinfo);
	}
	
	@Override
	public void update(BaseinfoEntity baseinfo){
		baseinfoDao.update(baseinfo);
	}
	
	@Override
	public void delete(Integer id){
		baseinfoDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		baseinfoDao.deleteBatch(ids);
	}
	
}
