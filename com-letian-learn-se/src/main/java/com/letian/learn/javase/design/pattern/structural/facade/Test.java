package com.letian.learn.javase.design.pattern.structural.facade;

/**
 * @author :  lihao
 * @date : 2020/7/7 14:38
 */
public class Test {
    public static void main(String[] args) {
        ShapeFacade shapeFacade = new ShapeFacade();
        shapeFacade.drawCircle();
        shapeFacade.drawSquare();
    }
}
