package cn.cisdom.base.service.impl;

import cn.cisdom.base.dao.PasswdrcDao;
import cn.cisdom.base.dao.UserDao;
import cn.cisdom.base.dao.VerifycodeDao;
import cn.cisdom.base.entity.PasswdrcEntity;
import cn.cisdom.base.entity.UserEntity;
import cn.cisdom.base.entity.VerifycodeEntity;
import cn.cisdom.base.service.UserService;
import cn.cisdom.base.utils.IdGen;
import cn.cisdom.base.utils.RRException;
import cn.cisdom.base.validator.Assert;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;


@Service("userService")
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private VerifycodeDao codeDao;
    @Autowired
    private PasswdrcDao pwdDao;

    @Override
    public UserEntity queryObject(String userId) {
        return userDao.queryObject(userId);
    }

    @Override
    public List<UserEntity> queryList(Map<String, Object> map) {
        return userDao.queryList(map);
    }

    @Override
    public int queryTotal(Map<String, Object> map) {
        return userDao.queryTotal(map);
    }

//    @Override
//    public void save(String mobile, String password) {
//        UserEntity user = new UserEntity();
//        user.setMobile(mobile);
//        user.setPassword(DigestUtils.sha256Hex(password));
//        user.setCreateTime(new Date());
//        userDao.save(user);
//    }

    @Override
    public void save(UserEntity user) {
        userDao.save(user);
    }

    @Transactional
    @Override
    public void update(UserEntity user) {
        userDao.update(user);
        final PasswdrcEntity lastPwd = pwdDao.queryByUserId(user.getId()).get(0);
        final String newPwd = user.getPassword();
        if (!newPwd.equals(lastPwd)) {
            lastPwd.setUserId(user.getId());
            lastPwd.setId(null);
            lastPwd.setSetTime(new Date());
            lastPwd.setPasswd(newPwd);
            pwdDao.save(lastPwd);
        }
    }

    @Override
    public void delete(String userId) {
        userDao.delete(userId);
    }

    @Override
    public void deleteBatch(String[] userIds) {
        userDao.deleteBatch(userIds);
    }

    @Override
    public UserEntity queryByMobile(String mobile) {
        return userDao.queryByMobile(mobile);
    }

    @Override
    public String login(String mobile, String password) {
        UserEntity user = queryByMobile(mobile);
        Assert.isNull(user, "手机号或密码错误");

        //密码错误
        if (!user.getPassword().equals(password)) {
            throw new RRException("手机号或密码错误");
        }

        user.setLastLoginTime(new Date());

        userDao.update(user);

        return user.getId();
    }

    @Transactional
    @Override
    public String register(String mobile, String password, String code) {
        UserEntity user = queryByMobile(mobile);
        if (user != null) {
            throw new RRException("用户已存在，请登录");
        }
        Map<String,Object> query = new HashedMap();
        query.put("mobile",mobile);
        query.put("type",String.valueOf(1));
        query.put("status",String.valueOf(0));
        List<VerifycodeEntity> codes = codeDao.queryValidList(query);
        if (null == codes || codes.isEmpty()) {
            throw new RRException("请输入正确的验证码");
        }
        for (VerifycodeEntity entity:codes){
            if (entity.getCode().equalsIgnoreCase(code)) {
                if(new Date().after(entity.getExpireTime())){
                    throw new RRException("验证码已过期");
                } else {
                    final VerifycodeEntity vc = entity;
                    vc.setStatus(String.valueOf(1));
                    codeDao.update(vc);
                    break;
                }
            } else {
                throw new RRException("请输入正确的验证码");
            }
        }
        user = new UserEntity();
        user.setId(IdGen.GenId());
        final Date now = new Date();
        user.setCreateTime(now);
        user.setMobile(mobile);
//        user.setUserName(userName);
        user.setPassword(password);
        user.setStatus(0);
        user.setLastLoginTime(now);
        userDao.save(user);

        final PasswdrcEntity pwd = new PasswdrcEntity();
        pwd.setSetTime(new Date());
        pwd.setUserId(user.getId());
        pwd.setPasswd(password);
        pwdDao.save(pwd);

        return user.getId();
    }

}
