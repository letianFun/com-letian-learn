package com.letian.learn.javase.design.pattern.creational.factory;

import cn.hutool.core.util.ObjectUtil;

/**
 * @author :  lihao
 * @date : 2020/6/10 12:59
 * @description :
 */
public class Factory {

    public static Mouse getPerson(Class<? extends Mouse> c) {
        if (ObjectUtil.equal(c, DellMouse.class)) {
            return new DellMouse();
        } else if (ObjectUtil.equal(c, LenovoMouse.class)) {
            return new LenovoMouse();
        } else {
            return () -> System.out.println("我是人类!");
        }
    }
}
