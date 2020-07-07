package com.letian.learn.javase.design.pattern.structural.facade;

/**
 * @author :  lihao
 * @date : 2020/7/7 14:35
 */
public class Square implements Shape {
    @Override
    public void draw() {
        System.out.println("画一个正方形");
    }
}
