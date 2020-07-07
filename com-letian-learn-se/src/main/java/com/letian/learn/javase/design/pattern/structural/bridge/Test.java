package com.letian.learn.javase.design.pattern.structural.bridge;

/**
 * @author :  lihao
 * @date : 2020/7/6 11:05
 */
public class Test {
    public static void main(String[] args) {
        //圆形
        Shape redCircle = new Circle(new RedColor());
        Shape greenCircle = new Circle(new GreenColor());
        redCircle.desc();
        greenCircle.desc();
        //正方形
        Shape redSquare = new Square(new RedColor());
        Shape greenSquare = new Square(new GreenColor());
        redSquare.desc();
        greenSquare.desc();
    }
}
