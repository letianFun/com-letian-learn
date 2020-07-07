package com.letian.learn.javase.design.pattern.behavioral.chain_of_responsibility;

/**
 * @author :  lihao
 * @date : 2020/7/2 14:44
 */
public abstract class AbstractLogger {

    public static int INFO = 3;
    public static int DEBUG = 2;
    public static int ERROR = 1;

    protected int level;

    protected AbstractLogger nextLogger;

    public void setNextLogger(AbstractLogger nextLogger) {
        this.nextLogger = nextLogger;
    }

    public void logMessage(int level, String message) {
        //此处控制调用的次数，如果是请假审批处理 就调用链被一个执行后，后面的不应执行
        //如果是日志，比他大的级别都可以被输出
        if (this.level <= level) {
            write(message);
        }
        if (nextLogger != null) {
            nextLogger.logMessage(level, message);
        }
    }

    abstract protected void write(String message);
}
