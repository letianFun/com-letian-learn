package com.letian.learn.javase.design.pattern.structural.adapter;

/**
 * @author :  lihao
 * @date : 2020/7/2 11:51
 */
public class Test {
    public static void main(String[] args) {

        Client client = new Client();
        Adaptee adaptee = new Adaptee();
        Target target = new Adapter(client,adaptee);
        target.typeCToHDMI();

    }
}
