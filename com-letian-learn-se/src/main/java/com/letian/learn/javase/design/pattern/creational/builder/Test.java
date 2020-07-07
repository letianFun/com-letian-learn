package com.letian.learn.javase.design.pattern.creational.builder;

/**
 * @author :  lihao
 * @date : 2020/7/3 9:34
 */
public class Test {
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("a").append("b").append("c").append("d");
        System.err.println(stringBuilder.toString());
    }
}
