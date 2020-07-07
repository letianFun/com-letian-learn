package com.letian.learn.javase.design.pattern.structural.flyweight;

import java.util.HashMap;
import java.util.Map;

/**
 * @author :  lihao
 * @date : 2020/7/7 14:45
 */
public class ShapeFactory {
    private static Map<String, Shape> circleMap = new HashMap<>();

    public static Shape getCircle(String color) {
        Shape shape = circleMap.get(color);
        if (shape == null) {
            System.out.println("create----");
            shape = new Circle(color);
            circleMap.put(color, shape);
        }
        return shape;
    }
}
