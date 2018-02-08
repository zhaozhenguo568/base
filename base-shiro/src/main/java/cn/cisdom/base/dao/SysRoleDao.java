package cn.cisdom.base.dao;


import cn.cisdom.base.entity.SysRoleEntity;

import java.util.List;

/**
 * 角色管理
 * 
 * @author zhenglee
 *
 */
public interface SysRoleDao extends BaseDao<SysRoleEntity> {
	
	/**
	 * 查询用户创建的角色ID列表
	 */
	List<Long> queryRoleIdList(Long createUserId);
}
