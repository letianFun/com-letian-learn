package com.letian.learn.javase.design.pattern.structural.decorator;

/**
 *　装饰器模式是动态地将责任附加到对象上。若要扩展功能，装饰器提供了比继承更有弹性的替代方案。
 * 以上的定义比较拗口，通俗的讲装饰器是对原有的方法的增强，跟后续要讲的代理模式很像，区别在于代理模式是屏蔽了代理类，装饰器模式注重附加额外的功能。
 *
 *
 * @author :  lihao
 * @date : 2020/7/2 9:13
 */
public class Test {

    public static void main(String[] args) {
        /**  https://www.cnblogs.com/sgx2019/p/11333131.html
         * Component：一个接口或者抽象类。
         * ConcreteComponent：具体的组件实现类。
         * --------------------------------------
         *  上面是我们的逻辑代码，下面就是我们要增加的 装饰器模式
         * ---------------------------------------
         * Decorator：装饰器，通常是抽象类。每个装饰器都有一个组件，是对Component的引用。
         * ConcreteDecoratorA：具体的装饰器的实现类，继承自装饰器。
         * ConcreteDecoratorB：具体的装饰器的实现类，继承自装饰器。
         */
        ConcreteDecoratorA concreteDecoratorA = new ConcreteDecoratorA(new ConcreteComponent());
        concreteDecoratorA.doSomeThing();
    }
}
