package com.letian.learn.javase.design.pattern.behavioral.strategy;

import org.springframework.stereotype.Service;

import java.math.BigDecimal;

/**
 * @author :  lihao
 * @date : 2020/6/30 15:31
 */
@Service
public class SuperVipUser implements UserPay {

    @Override
    public BigDecimal pay(BigDecimal orderPrice) {
        return BigDecimal.valueOf(0.6).multiply(orderPrice);
    }
}
