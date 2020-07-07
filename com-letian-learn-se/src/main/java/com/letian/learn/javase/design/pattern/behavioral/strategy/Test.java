package com.letian.learn.javase.design.pattern.behavioral.strategy;

import java.math.BigDecimal;

/**
 * @author :  lihao
 * @date : 2020/6/30 15:51
 */
public class Test {
    public static void test(String[] args) {
        //模拟数据库查询出用户
        User vipUser = new User(UserVipEnum.VIP.getType());
        User superVipUser = new User(UserVipEnum.SUP_VIP.getType());
        //同一个金额，不同用户使用不用的策略
        BigDecimal money = BigDecimal.valueOf(100);
        System.out.println(calPrice(money, vipUser));
        System.out.println(calPrice(money, superVipUser));
    }


    /**
     * @author mhcoding
     */
    public static BigDecimal calPrice(BigDecimal orderPrice, User user) {
        UserPay strategy = UserPayStrategyFactory.getByUserType(user.getVipType());
        return strategy.pay(orderPrice);
    }
}
