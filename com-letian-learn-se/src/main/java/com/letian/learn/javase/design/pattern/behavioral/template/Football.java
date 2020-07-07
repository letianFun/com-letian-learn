package com.letian.learn.javase.design.pattern.behavioral.template;

/**
 * @author :  lihao
 * @date : 2020/7/3 14:25
 */
public class Football extends Game {
    @Override
    void initialize() {
        System.out.println("Football === initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Football === startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Football === endPlay");
    }
}
