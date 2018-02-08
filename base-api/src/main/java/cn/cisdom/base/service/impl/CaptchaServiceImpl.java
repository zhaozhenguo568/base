package cn.cisdom.base.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

import cn.cisdom.base.dao.CaptchaDao;
import cn.cisdom.base.entity.CaptchaEntity;
import cn.cisdom.base.service.CaptchaService;



@Service("captchaService")
public class CaptchaServiceImpl implements CaptchaService {
	@Autowired
	private CaptchaDao captchaDao;
	
	@Override
	public CaptchaEntity queryObject(Integer id){
		return captchaDao.queryObject(id);
	}
	
	@Override
	public List<CaptchaEntity> queryList(Map<String, Object> map){
		return captchaDao.queryList(map);
	}
	
	@Override
	public int queryTotal(Map<String, Object> map){
		return captchaDao.queryTotal(map);
	}
	
	@Override
	public void save(CaptchaEntity captcha){
		captchaDao.save(captcha);
	}
	
	@Override
	public void update(CaptchaEntity captcha){
		captchaDao.update(captcha);
	}
	
	@Override
	public void delete(Integer id){
		captchaDao.delete(id);
	}
	
	@Override
	public void deleteBatch(Integer[] ids){
		captchaDao.deleteBatch(ids);
	}

	@Override
	public int exists(String captcha) {
		return captchaDao.exists(captcha);
	}

	@Override
	public int deleteByCaptcha(String captcha) {
		return captchaDao.deleteByCaptcha(captcha);
	}

}
