package com.letian.learn.javase.design.pattern.creational.builder;

/**
 * @author :  lihao
 * @date : 2020/7/3 10:17
 */
public class StringBuilder extends AbstractStringBuilder {


    @Override
    public StringBuilder append(String str) {
        super.append(str);
        return this;
    }

    @Override
    public String toString() {
        return value;
    }
}
