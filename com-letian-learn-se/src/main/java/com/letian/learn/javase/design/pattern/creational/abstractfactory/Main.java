package com.letian.learn.javase.design.pattern.creational.abstractfactory;

/**
 * @author :  lihao
 * @date : 2020/6/10 14:32
 * @description :
 */
public class Main {
    public static void main(String[] args) {
        LenovoFactory lenovoFactory = new LenovoFactory();
        lenovoFactory.newProduct();
    }
}
