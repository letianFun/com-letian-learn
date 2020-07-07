package com.letian.learn.javase.design.pattern.structural.adapter;

/**
 * @author :  lihao
 * @date : 2020/7/2 11:39
 */
public class Adapter extends Target {

    private Client client;

    private Adaptee adaptee;

    public Adapter(Client client, Adaptee adaptee) {
        this.client = client;
        this.adaptee = adaptee;
    }

    @Override
    public void typeCToHDMI() {
        String typeC = client.typeC();
        System.out.println(typeC);
        System.out.println("--解析typeC 信号,转换成HDMI");
        adaptee.HDMI();
    }
}
