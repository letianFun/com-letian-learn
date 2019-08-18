package com.letian.learn.aop.systemlog;


import com.letian.learn.aop.systemlog.enums.ChildrenLogEnum;
import com.letian.learn.aop.systemlog.enums.OperatingLogEnum;
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
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SystemLog {

    /**
     * 日志父类枚举
     */
    ParentLogEnum parentType() default ParentLogEnum.NOT;

    /**
     * 日志子类
     */
    ChildrenLogEnum childrenType() default ChildrenLogEnum.NOT;

    /**
     * 日志操作类型
     */
    OperatingLogEnum operateType();

    /**
     * 日志内容
     */
    String content() default "";

    /**
     * 是否记录时间
     */
    boolean time() default false;

}
