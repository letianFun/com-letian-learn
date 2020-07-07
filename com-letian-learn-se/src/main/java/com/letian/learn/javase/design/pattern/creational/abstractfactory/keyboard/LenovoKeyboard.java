package com.letian.learn.javase.design.pattern.creational.abstractfactory.keyboard;

/**
 * @author :  lihao
 * @date : 2020/6/10 13:52
 * @description :
 */
public class LenovoKeyboard implements Keyboard {

    @Override
    public void sayHello() {
        System.out.println("联想键盘,链接一切想象!!");
    }
}
