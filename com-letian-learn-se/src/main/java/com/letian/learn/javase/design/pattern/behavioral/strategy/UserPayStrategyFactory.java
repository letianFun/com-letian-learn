package com.letian.learn.javase.design.pattern.behavioral.strategy;

import cn.hutool.core.lang.Assert;
import com.letian.learn.javase.util.SpringContextHolder;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author :  lihao
 * @date : 2020/6/30 15:35
 */
//@Service
public class UserPayStrategyFactory implements InitializingBean {

    private static Map<Integer, UserPay> services = new ConcurrentHashMap<>();

    public static UserPay getByUserType(Integer type) {
        Assert.notEmpty(services);
        return services.get(type);
    }

    public static void putUserPayStrategy(Integer type, UserPay userPay) {
        services.put(type, userPay);
    }

    @Override
    public void afterPropertiesSet() throws Exception {


    }
}
