package com.letian.learn.javase.design.pattern.creational.abstractfactory.keyboard;

/**
 * @author :  lihao
 * @date : 2020/6/10 13:53
 * @description :
 */
public class DellKeyboard implements Keyboard {
    @Override
    public void sayHello() {
        System.out.println("戴尔键盘,带尔等起飞!!");
    }
}
