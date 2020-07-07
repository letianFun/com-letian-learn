package com.letian.learn.javase.design.pattern.creational.prototype;

/**
 * @author :  lihao
 * @date : 2020/7/3 12:41
 */
public abstract class Shape implements Cloneable {

    protected String name;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public String toString() {
        return "Shape{" +
                "name='" + name + '\'' +
                '}';
    }
}
