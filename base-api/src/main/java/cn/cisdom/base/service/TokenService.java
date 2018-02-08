package cn.cisdom.base.service;


import cn.cisdom.base.entity.TokenEntity;

import java.util.Map;

/**
 * 用户Token
 * 
 * @author zhenglee
 *
 */
public interface TokenService {

	TokenEntity queryByUserId(String userId);

	TokenEntity queryByToken(String token);
	
	void save(TokenEntity token);
	
	void update(TokenEntity token);

	void deleteByUserId(Long userId);
	/**
	 * 生成token
	 * @param userId  用户ID
	 * @return        返回token相关信息
	 */
	Map<String, Object> createToken(String userId);

}
