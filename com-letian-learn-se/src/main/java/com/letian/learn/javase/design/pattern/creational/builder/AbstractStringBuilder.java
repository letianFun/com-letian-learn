package com.letian.learn.javase.design.pattern.creational.builder;

/**
 * @author :  lihao
 * @date : 2020/7/3 10:11
 */
public abstract class AbstractStringBuilder {

    protected String value="";

    public AbstractStringBuilder append(String str) {
        value = value.concat(str);
        return this;
    }


}
