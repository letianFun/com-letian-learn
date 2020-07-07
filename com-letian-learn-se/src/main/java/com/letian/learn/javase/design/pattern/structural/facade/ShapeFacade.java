package com.letian.learn.javase.design.pattern.structural.facade;

/**
 * @author :  lihao
 * @date : 2020/7/7 14:37
 */
public class ShapeFacade {
    private Shape circle;
    private Shape square;

    public ShapeFacade() {
        this.circle = new Circle();
        this.square = new Square();
    }

    public void drawCircle(){
        circle.draw();
    }


    public void drawSquare(){
        square.draw();
    }
}
