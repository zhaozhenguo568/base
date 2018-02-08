package cn.cisdom.base.interceptor;

import cn.cisdom.base.annotation.IgnoreAuth;
import cn.cisdom.base.entity.TokenEntity;
import cn.cisdom.base.service.TokenService;
import cn.cisdom.base.service.impl.TokenServiceImpl;
import cn.cisdom.base.utils.RRException;

import java.util.Date;
import java.util.HashMap;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * 权限(Token)验证
 * @author zhenglee
 *
 */
@Component
public class AuthorizationInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private TokenService tokenService;

    public static final String LOGIN_USER_KEY = "LOGIN_USER_KEY";

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.addHeader("Access-Control-Allow-Origin","*");
        response.addHeader("Access-Control-Allow-Headers","Origin, authCode, token, Content-Type, Accept");
        response.addHeader("Access-Control-Allow-Methods","GET, POST, PUT,DELETE");

        IgnoreAuth annotation;
        if(handler instanceof HandlerMethod) {
            annotation = ((HandlerMethod) handler).getMethodAnnotation(IgnoreAuth.class);
        }else{
            return true;
        }

        //如果有@IgnoreAuth注解，则不验证token
        if(annotation != null){
            return true;
        }

        //从header中获取token
        String token = request.getHeader("token");
        //如果header中不存在token，则从参数中获取token
        if(StringUtils.isBlank(token)){
            token = request.getParameter("token");
        }

        //token为空
        if(StringUtils.isBlank(token)){
            throw new RRException("token不能为空");
        }

        //查询token信息
        TokenEntity tokenEntity = tokenService.queryByToken(token);
        if (tokenEntity == null || tokenEntity.getExpireTime().getTime() < System.currentTimeMillis()) {
            throw new RRException("token失效，请重新登录", -1);
        }
        final Date now = new Date();
        tokenEntity.setExpireTime(new Date(now.getTime() + TokenServiceImpl.EXPIRE * 1000));
        tokenEntity.setUpdateTime(now);
        tokenService.update(tokenEntity);

        //设置userId到request里，后续根据userId，获取用户信息
        request.setAttribute(LOGIN_USER_KEY, tokenEntity.getUserId());

        Map<String,Object> params = new HashMap();
        request.setAttribute("key",params);

        return true;
    }

}
