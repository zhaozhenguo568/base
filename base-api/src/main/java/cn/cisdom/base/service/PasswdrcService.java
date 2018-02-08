package cn.cisdom.base.service;

import cn.cisdom.base.entity.PasswdrcEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户登录密码设置记录表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:05
 */
public interface PasswdrcService {
	
	PasswdrcEntity queryObject(Integer id);
	
	List<PasswdrcEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(PasswdrcEntity passwdrc);
	
	void update(PasswdrcEntity passwdrc);
	
	void delete(Integer id);
	
	void deleteBatch(Integer[] ids);
}
