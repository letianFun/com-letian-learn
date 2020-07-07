package com.letian.learn.javase.design.pattern.behavioral.observer;

import com.letian.learn.javase.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author :  lihao
 * @date : 2020/6/30 16:31
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class ObserverTest {

    @org.junit.Test
    public void test() {
        //获取到所有实现 Observer 接口的 类
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
        Map<String, Observer> beansOfType = applicationContext.getBeansOfType(Observer.class);
        Collection<Observer> values = beansOfType.values();
        for (Observer next : values) {
            Subject.addObserver(next);
        }
        //执行方法
        Subject.notifyAllObservers();
    }
}
