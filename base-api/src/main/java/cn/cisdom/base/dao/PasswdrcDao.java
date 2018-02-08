package cn.cisdom.base.dao;

import cn.cisdom.base.entity.PasswdrcEntity;

import java.util.List;

/**
 * 用户登录密码设置记录表
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-06 09:56:05
 */
public interface PasswdrcDao extends BaseDao<PasswdrcEntity> {

	List<PasswdrcEntity> queryByUserId(String userID);

}
