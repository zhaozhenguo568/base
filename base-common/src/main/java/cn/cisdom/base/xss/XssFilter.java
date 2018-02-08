package cn.cisdom.base.xss;

import cn.cisdom.base.utils.ConfigConstant;
import cn.cisdom.base.utils.ParamsUtils;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.Map;

/**
 * XSS过滤
 *
 * @author zhenglee
 */
public class XssFilter implements Filter {

    @Override
    public void init(FilterConfig config) throws ServletException {
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        XssHttpServletRequestWrapper wrapper = null;
        if (ConfigConstant.IS_DEBUG) {
            Map<String, String[]> parmsMap = request.getParameterMap();
            if (parmsMap != null && parmsMap.size() != 0) {
                final String encode = request.getParameterMap().keySet().iterator().next() + "=";
                String decode = null;
                try {
                    decode = ParamsUtils.decrypt(encode, ConfigConstant.API_SALT);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                Map<String, Object> map = ParamsUtils.getUrlParams(decode);
                wrapper = new XssHttpServletRequestWrapper((HttpServletRequest) request, map);
                wrapper.addAllParameters(map);
            } else {
                wrapper = new XssHttpServletRequestWrapper(
                        (HttpServletRequest) request);
            }
        } else {
            wrapper = new XssHttpServletRequestWrapper(
                    (HttpServletRequest) request);
        }
        chain.doFilter(wrapper, response);
    }

    @Override
    public void destroy() {
    }

}