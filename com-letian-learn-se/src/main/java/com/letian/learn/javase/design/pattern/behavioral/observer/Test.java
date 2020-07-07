package com.letian.learn.javase.design.pattern.behavioral.observer;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @author :  lihao
 * @date : 2020/6/30 11:50
 */
public class Test {
    public static void main(String[] args) {
        //手动添加 观察者， test 可见 spring 统一添加观察者
        Subject.addObserver(new OneObserver());
        Subject.addObserver(new OneChildObserver());
        Subject.addObserver(new TwoObserver());
        //发起调用
        Subject.notifyAllObservers();
    }
}
