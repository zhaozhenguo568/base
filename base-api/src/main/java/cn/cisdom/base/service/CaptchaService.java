package cn.cisdom.base.service;

import cn.cisdom.base.entity.CaptchaEntity;

import java.util.List;
import java.util.Map;

/**
 * 图形验证码
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-07 15:58:37
 */
public interface CaptchaService {
	
	CaptchaEntity queryObject(Integer id);
	
	List<CaptchaEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(CaptchaEntity captcha);
	
	void update(CaptchaEntity captcha);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	int exists(String captcha);

	int deleteByCaptcha(String captcha);
}
