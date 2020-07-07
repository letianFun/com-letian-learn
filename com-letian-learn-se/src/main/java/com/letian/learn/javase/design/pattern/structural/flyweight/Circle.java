package com.letian.learn.javase.design.pattern.structural.flyweight;

/**
 * @author :  lihao
 * @date : 2020/7/7 14:44
 */
public class Circle implements Shape {

    private String color;

    public Circle(String color) {
        this.color = color;
    }

    @Override
    public void draw() {
        System.out.println(color.concat("的圆形"));
    }

    @Override
    public String toString() {
        return "Circle{" +
                "color='" + color + '\'' +
                '}';
    }
}
