package cn.cisdom.base.dao;

import cn.cisdom.base.entity.CaptchaEntity;
import org.apache.ibatis.annotations.Mapper;

/**
 * 图形验证码
 * 
 * @author zhenglee
 * @email 18368053@qq.com
 * @date 2017-12-07 15:58:37
 */
@Mapper
public interface CaptchaDao extends BaseDao<CaptchaEntity> {

    int exists(String captcha);

    int deleteByCaptcha(String captcha);

}
