package com.letian.learn.javase.design.pattern.structural.composite;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  lihao
 * @date : 2020/7/6 11:46
 */
public class Test {
    public static void main(String[] args) {
        Menu menu = new Menu();
        menu.setName("一级菜单 1-1");
        menu.setChildren(new ArrayList<>());
        Menu children = new Menu();
        children.setName("二级菜单 1-2");
        menu.getChildren().add(children);
        System.err.println(menu);
    }
}
