package com.letian.learn.javase.design.pattern.structural.bridge;

/**
 * @author :  lihao
 * @date : 2020/7/6 11:03
 */
public class Square extends Shape {

    public Square(Color color) {
        super(color);
    }

    @Override
    protected void desc() {
        System.out.println(color.value().concat("正方形"));
    }
}
