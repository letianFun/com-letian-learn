package com.letian.learn.javase.design.pattern.behavioral.chain_of_responsibility;

/**
 * @author :  lihao
 * @date : 2020/7/2 14:50
 */
public class InfoLogger extends AbstractLogger {

    public InfoLogger() {
        this.level = AbstractLogger.INFO;
    }

    @Override
    protected void write(String message) {
        System.out.println("---[info]----" + message);
    }
}
