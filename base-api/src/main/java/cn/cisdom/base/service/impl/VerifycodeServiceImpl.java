package cn.cisdom.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.dao.VerifycodeDao;
import cn.cisdom.base.entity.VerifycodeEntity;
import cn.cisdom.base.service.VerifycodeService;



@Service("verifycodeService")
public class VerifycodeServiceImpl implements VerifycodeService {
	@Autowired
	private VerifycodeDao verifycodeDao;
	
	@Override
	public VerifycodeEntity queryObject(Integer id){
		return verifycodeDao.queryObject(id);
	}
	
	@Override
	public List<VerifycodeEntity> queryList(Map<String, Object> map){
		return verifycodeDao.queryList(map);
	}

	@Override
	public List<VerifycodeEntity> queryValidList(Map<String, Object> map) {
		return verifycodeDao.queryValidList(map);
	}

	@Override
	public int queryTotal(Map<String, Object> map){
		return verifycodeDao.queryTotal(map);
	}
	
	@Override
	public void save(VerifycodeEntity verifycode){
		verifycodeDao.save(verifycode);
	}
	
	@Override
	public void update(VerifycodeEntity verifycode){
		verifycodeDao.update(verifycode);
	}
	
	@Override
	public void delete(Integer id){
		verifycodeDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		verifycodeDao.deleteBatch(ids);
	}

	@Override
	public VerifycodeEntity queryByMobile(String mobile) {
		return verifycodeDao.queryByMobile(mobile);
	}

}
