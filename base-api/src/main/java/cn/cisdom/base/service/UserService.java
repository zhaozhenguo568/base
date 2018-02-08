package cn.cisdom.base.service;

import cn.cisdom.base.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户基础信息表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:05
 */
public interface UserService {
	
	UserEntity queryObject(String id);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);

//	void save(String mobile, String password);
	
	void save(UserEntity user);
	
	void update(UserEntity user);
	
	void delete(String id);
	
	void deleteBatch(String[] ids);

	UserEntity queryByMobile(String mobile);

	/**
	 * 用户登录
	 *
	 * @param mobile   手机号
	 * @param password 密码
	 * @return 返回用户ID
	 */
	String login(String mobile, String password);

	/**
	 * 用户登录
	 *
	 * @param mobile   手机号
	 * @param password 密码
	 * @param code     验证码
	 * @return 返回用户ID
	 */
	String register(String mobile, String password, String code);

}
