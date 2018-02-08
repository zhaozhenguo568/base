package cn.cisdom.base.service;

import cn.cisdom.base.entity.VerifycodeEntity;

import java.util.List;
import java.util.Map;

/**
 * 验证码发送记录表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:04
 */
public interface VerifycodeService {
	
	VerifycodeEntity queryObject(Integer id);
	
	List<VerifycodeEntity> queryList(Map<String, Object> map);

	List<VerifycodeEntity> queryValidList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(VerifycodeEntity verifycode);
	
	void update(VerifycodeEntity verifycode);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);

	VerifycodeEntity queryByMobile(String mobile);
}
