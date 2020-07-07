package com.letian.learn.javase.design.pattern.behavioral.chain_of_responsibility;

/**
 * @author :  lihao
 * @date : 2020/7/2 14:51
 */
public class ErrorLogger extends AbstractLogger {

    public ErrorLogger() {
        this.level = AbstractLogger.ERROR;
    }

    @Override
    protected void write(String message) {
        System.out.println("---[error]----" + message);
    }


}
