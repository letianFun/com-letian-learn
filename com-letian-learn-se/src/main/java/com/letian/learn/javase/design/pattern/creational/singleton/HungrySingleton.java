package com.letian.learn.javase.design.pattern.creational.singleton;

/**
 * @author :  lihao
 * @date : 2020/6/10 14:43
 * @description :
 */
public class HungrySingleton {

    private static HungrySingleton instance = new HungrySingleton();
    private HungrySingleton (){}
    public static HungrySingleton getInstance() {
        return instance;
    }
}
