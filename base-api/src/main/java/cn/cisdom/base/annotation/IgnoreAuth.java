package cn.cisdom.base.annotation;

import java.lang.annotation.*;

/**
 * 忽略Token验证
 * @author zhenglee
 *
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface IgnoreAuth {

}
