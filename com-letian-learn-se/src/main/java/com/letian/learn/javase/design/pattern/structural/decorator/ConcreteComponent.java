package com.letian.learn.javase.design.pattern.structural.decorator;

/**
 * @author :  lihao
 * @date : 2020/7/2 10:47
 */
public class ConcreteComponent implements Component {
    @Override
    public void doSomeThing() {
        System.out.println("---开始处理一些事情-----");
    }
}
