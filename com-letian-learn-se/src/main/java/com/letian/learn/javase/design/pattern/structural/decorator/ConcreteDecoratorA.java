package com.letian.learn.javase.design.pattern.structural.decorator;

/**
 * @author :  lihao
 * @date : 2020/7/2 10:53
 */
public class ConcreteDecoratorA extends Decorator {
    public ConcreteDecoratorA(Component component) {
        super(component);
    }

    @Override
    public void doSomeThing() {
        System.out.println("----A类之前------");
        super.doSomeThing();
        System.out.println("----A类之后------");
    }
}
