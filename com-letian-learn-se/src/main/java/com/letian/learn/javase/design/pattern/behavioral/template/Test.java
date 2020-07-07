package com.letian.learn.javase.design.pattern.behavioral.template;

/**
 * @author :  lihao
 * @date : 2020/7/3 14:26
 */
public class Test {
    public static void main(String[] args) {
        Game cricket = new Cricket();
        cricket.play();
        Game football = new Football();
        football.play();
    }
}
