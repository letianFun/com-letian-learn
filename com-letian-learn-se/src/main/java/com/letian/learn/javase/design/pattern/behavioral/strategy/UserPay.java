package com.letian.learn.javase.design.pattern.behavioral.strategy;

import org.springframework.beans.factory.InitializingBean;

import java.math.BigDecimal;

/**
 * @author :  lihao
 * @date : 2020/6/30 15:28
 */
public interface UserPay {

    /**
     * 计算应付价格
     */
    BigDecimal pay(BigDecimal orderPrice);
}
