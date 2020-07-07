package com.letian.learn.javase.design.pattern.behavioral.observer;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  lihao
 * @date : 2020/6/30 11:43
 */
public class Subject {

    /**
     * 观察者列表
     */
    private static List<Observer> observerList = new ArrayList<>();

    /*** 新增观察者
     *
     * @param observer 观察者实体
     * @author lihao
     * @date 2020/6/30 11:47
     * @return 添加结果
     */
    public static boolean addObserver(Observer observer) {
        return observerList.add(observer);
    }

    public static void notifyAllObservers() {
        for (Observer observer : observerList) {
            //此处的同步处理，可以优化成异步处理
            observer.update();
        }
    }
}
