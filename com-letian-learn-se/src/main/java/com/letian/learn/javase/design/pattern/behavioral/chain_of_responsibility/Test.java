package com.letian.learn.javase.design.pattern.behavioral.chain_of_responsibility;

/**
 * @author :  lihao
 * @date : 2020/7/2 14:55
 */
public class Test {

    private static AbstractLogger getChainOfLoggers() {

        AbstractLogger errorLogger = new ErrorLogger();
        AbstractLogger debugLogger = new DebugLogger();
        AbstractLogger infoLogger = new InfoLogger();
        errorLogger.setNextLogger(debugLogger);
        debugLogger.setNextLogger(infoLogger);
        return errorLogger;
    }

    public static void main(String[] args) {
        AbstractLogger loggerChain = getChainOfLoggers();

        loggerChain.logMessage(AbstractLogger.INFO, "This is an info.");
        System.out.println("======================================");
        loggerChain.logMessage(AbstractLogger.DEBUG, "This is a debug ");
        System.out.println("======================================");
        loggerChain.logMessage(AbstractLogger.ERROR, "This is an error");
    }
}
