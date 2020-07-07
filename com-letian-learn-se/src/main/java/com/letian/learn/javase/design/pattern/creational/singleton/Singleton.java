package com.letian.learn.javase.design.pattern.creational.singleton;

/**
 * 枚举类型的单例
 *
 * @author :  lihao
 * @date : 2020/6/12 8:51
 */
public class Singleton {
    /**
     * 私有化构造方法
     */
    private Singleton() {
    }

    private enum SingletonEnum {
        /**
         *
         */
        INSTANCE;
        /**
         * 枚举变量
         */
        private Singleton singleton;

        SingletonEnum() {
            singleton = new Singleton();
        }

        public Singleton getInstance() {
            return singleton;
        }
    }

    public static Singleton getInstance() {
        return SingletonEnum.INSTANCE.getInstance();
    }

}
