package com.letian.learn.javase.design.pattern.creational.factory;

/**
 * @author :  lihao
 * @date : 2020/6/10 13:03
 * @description :
 */
public class Main {
    public static void main(String[] args) {
        //从工厂获取不同的对象
        Mouse Mouse = Factory.getPerson(DellMouse.class);
        Mouse.sayHello();
        Mouse Mouse1 = Factory.getPerson(LenovoMouse.class);
        Mouse1.sayHello();
    }
}
