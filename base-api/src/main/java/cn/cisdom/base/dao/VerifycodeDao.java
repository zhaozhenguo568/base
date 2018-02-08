package cn.cisdom.base.dao;

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
public interface VerifycodeDao extends BaseDao<VerifycodeEntity> {

    VerifycodeEntity queryByMobile(String mobile);

    List<VerifycodeEntity> queryValidList(Map<String, Object> map);

}
