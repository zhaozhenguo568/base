package cn.cisdom.base.dao;

import cn.cisdom.base.entity.UserEntity;

/**
 * 用户基础信息表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:05
 */
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);

}
