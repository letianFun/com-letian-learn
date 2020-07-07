package com.letian.learn.javase.design.pattern.behavioral.observer;

import org.springframework.stereotype.Service;

/**
 * @author :  lihao
 * @date : 2020/6/30 11:48
 */
@Service
public class OneObserver implements Observer {
    @Override
    public void update() {
        System.out.println("OneObserver-----------update");
    }
}
