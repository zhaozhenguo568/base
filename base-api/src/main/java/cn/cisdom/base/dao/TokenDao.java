package cn.cisdom.base.dao;


import cn.cisdom.base.entity.TokenEntity;

/**
 * 用户Token
 * 
 * @author zhenglee
 *
 */
public interface TokenDao extends BaseDao<TokenEntity> {
    
    TokenEntity queryByUserId(String userId);

    TokenEntity queryByToken(String token);

    void deleteByUserId(Long userId);
	
}
