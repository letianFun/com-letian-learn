package com.letian.learn.aop.systemlog;

import com.letian.learn.aop.systemlog.enums.ChildrenLogEnum;
import com.letian.learn.aop.systemlog.enums.ParentLogEnum;

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
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLogApi {
    /**
     * 日志信息
     */
    String message() default "";

    /**
     * 日志父类枚举
     */
    ParentLogEnum parentType();

    /**
     * 日志子类
     */
    ChildrenLogEnum childrenType();

}
