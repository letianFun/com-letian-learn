package com.letian.learn.javase.design.pattern.structural.bridge;

/**
 * @author :  lihao
 * @date : 2020/7/6 10:54
 */
public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public void desc() {
        System.out.println(color.value().concat("圆形"));
    }
}
