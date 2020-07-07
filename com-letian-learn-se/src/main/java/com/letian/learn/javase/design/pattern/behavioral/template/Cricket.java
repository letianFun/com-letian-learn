package com.letian.learn.javase.design.pattern.behavioral.template;

/**
 * @author :  lihao
 * @date : 2020/7/3 14:22
 */
public class Cricket extends Game {
    @Override
    void initialize() {
        System.out.println("Cricket === initialize");
    }

    @Override
    void startPlay() {
        System.out.println("Cricket === startPlay");
    }

    @Override
    void endPlay() {
        System.out.println("Cricket === endPlay");
    }
}
