package com.letian.learn.javase.design.pattern.creational.prototype;

/**
 * @author :  lihao
 * @date : 2020/7/3 12:50
 */
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Circle circle = new Circle();
        System.err.println(circle);
        Object clone = circle.clone();
        System.err.println(clone);
        System.err.println(circle == clone);
        System.err.println(circle.equals(clone));
    }
}
