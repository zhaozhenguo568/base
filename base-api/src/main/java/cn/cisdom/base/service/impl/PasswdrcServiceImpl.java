package cn.cisdom.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.dao.PasswdrcDao;
import cn.cisdom.base.entity.PasswdrcEntity;
import cn.cisdom.base.service.PasswdrcService;



@Service("passwdrcService")
public class PasswdrcServiceImpl implements PasswdrcService {
	@Autowired
	private PasswdrcDao passwdrcDao;
	
	@Override
	public PasswdrcEntity queryObject(Integer id){
		return passwdrcDao.queryObject(id);
	}
	
	@Override
	public List<PasswdrcEntity> queryList(Map<String, Object> map){
		return passwdrcDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return passwdrcDao.queryTotal(map);
	}
	
	@Override
	public void save(PasswdrcEntity passwdrc){
		passwdrcDao.save(passwdrc);
	}
	
	@Override
	public void update(PasswdrcEntity passwdrc){
		passwdrcDao.update(passwdrc);
	}
	
	@Override
	public void delete(Integer id){
		passwdrcDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		passwdrcDao.deleteBatch(ids);
	}
	
}
