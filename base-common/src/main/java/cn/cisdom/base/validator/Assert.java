package cn.cisdom.base.validator;

import cn.cisdom.base.utils.RRException;
import org.apache.commons.lang.StringUtils;

/**
 * 数据校验
 *
 * @author zhenglee
 */
public abstract class Assert {

    public static void isBlank(String str, String message) {
        if (StringUtils.isBlank(str)) {
            throw new RRException(message);
        }
    }

    public static void isNull(Object object, String message) {
        if (null == object) {
            throw new RRException(message);
        }
    }

    public static void isValid(Object... objects) {
        isValid("参数不正确", objects);
    }

    public static void isValid(String message, Object... objects) {
        for (Object obj : objects) {
            if (null == obj) {
                throw new RRException(message);
            }
        }
    }
}
