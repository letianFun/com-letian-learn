package com.letian.learn.javase.design.pattern.structural.decorator;

/**
 * @author :  lihao
 * @date : 2020/7/2 10:51
 */
public abstract class Decorator implements Component {
    private Component component;

    public Decorator(Component component) {
        this.component = component;
    }

    @Override
    public void doSomeThing() {
        component.doSomeThing();
    }
}
