package com.letian.learn.javase.design.pattern.behavioral.observer;

import org.springframework.stereotype.Service;

/**
 * @author :  lihao
 * @date : 2020/6/30 16:37
 */
@Service
public class OneChildObserver extends OneObserver {

    @Override
    public void update() {
        System.out.println("OneChildObserver ------- update");
    }
}
