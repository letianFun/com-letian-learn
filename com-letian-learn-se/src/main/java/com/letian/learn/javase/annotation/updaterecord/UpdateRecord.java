package com.letian.learn.javase.annotation.updaterecord;


import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


/**
 * @author : lh
 * @version : 1.0.0
 * @data : 2019-07-11
 **/
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
public @interface UpdateRecord {

    String value();

    Class methodClass() default UpdateRecord.class;

    String change() default "修改为";

    String pre() default "【";

    String suf() default "】";

    String character() default ",";

}
