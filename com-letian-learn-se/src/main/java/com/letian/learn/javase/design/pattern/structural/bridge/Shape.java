package com.letian.learn.javase.design.pattern.structural.bridge;

/**
 * @author :  lihao
 * @date : 2020/7/6 10:53
 */
public abstract class Shape {

    protected Color color;

    public Shape(Color color) {
        this.color = color;
    }

    protected abstract void desc();
}
