package com.letian.learn.javase.design.pattern.behavioral.chain_of_responsibility;

/**
 * @author :  lihao
 * @date : 2020/7/2 14:51
 */
public class DebugLogger extends AbstractLogger {

    public DebugLogger() {
        this.level = AbstractLogger.DEBUG;
    }

    @Override
    protected void write(String message) {
        System.out.println("---[debug]----" + message);
    }
}
