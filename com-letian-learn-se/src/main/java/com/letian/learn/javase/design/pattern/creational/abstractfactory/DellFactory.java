package com.letian.learn.javase.design.pattern.creational.abstractfactory;

import com.letian.learn.javase.design.pattern.creational.abstractfactory.keyboard.Keyboard;
import com.letian.learn.javase.design.pattern.creational.factory.Mouse;

/**
 * @author :  lihao
 * @date : 2020/6/10 14:27
 * @description :
 */
public class DellFactory implements PCFactory {
    @Override
    public Mouse createMouse() {
        return null;
    }

    @Override
    public Keyboard createKeyboard() {
        return null;
    }
}
