package com.letian.learn.javase.design.pattern.creational.singleton;

/**
 * @author :  lihao
 * @date : 2020/6/10 14:45
 * @description :
 */
public class LazySingleton {

    private volatile static LazySingleton singleton;
    private LazySingleton (){}
    public static LazySingleton getSingleton() {
        if (singleton == null) {
            synchronized (LazySingleton.class) {
                if (singleton == null) {
                    singleton = new LazySingleton();
                }
            }
        }
        return singleton;
    }
}
