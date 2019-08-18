package com.letian.learn.aop.systemlog;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 系统日志
 *
 * @author : lh
 * @version : 1.0.0
 * @data : 2019-07-11
 **/
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLogParam {
    /**
     * 参数名称
     */
    String value() default "";
}
