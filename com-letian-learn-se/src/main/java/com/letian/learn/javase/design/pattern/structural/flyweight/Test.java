package com.letian.learn.javase.design.pattern.structural.flyweight;

/**
 * @author :  lihao
 * @date : 2020/7/7 14:56
 */
public class Test {

    public static void main(String[] args) {
        String color = "red";
        Shape circle = ShapeFactory.getCircle(color);
        System.err.println(circle);
        Shape circle1 = ShapeFactory.getCircle(color);
        System.err.println(circle1);
    }
}
