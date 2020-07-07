package com.letian.learn.javase.design.pattern.behavioral.strategy;

import com.letian.learn.javase.util.SpringContextHolder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.util.Map;

/**
 * @author :  lihao
 * @date : 2020/6/30 15:51
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class StrategyTest {
    @Test
    public void test() {
        //找出所有  UserPay 的实现类
        ApplicationContext applicationContext = SpringContextHolder.getApplicationContext();
        Map<String, UserPay> beansOfType = applicationContext.getBeansOfType(UserPay.class);
        for (UserVipEnum userVipEnum : UserVipEnum.values()) {
            UserPay userPay = beansOfType.get(userVipEnum.getBeanName());
            if (userPay != null) {
                UserPayStrategyFactory.putUserPayStrategy(userVipEnum.getType(), userPay);
            }
        }

        //模拟数据库查询出用户
        User vipUser = new User(UserVipEnum.VIP.getType());
        User superVipUser = new User(UserVipEnum.SUP_VIP.getType());
        //
        BigDecimal money = BigDecimal.valueOf(100);
        System.out.println(calPrice(money, vipUser));
        System.out.println(calPrice(money, superVipUser));
    }

    /**
     * @author mhcoding
     */
    public static BigDecimal calPrice(BigDecimal orderPrice, User user) {
        UserPay strategy = UserPayStrategyFactory.getByUserType(user.getVipType());
        if (strategy == null) {
            return BigDecimal.ZERO;
        }
        return strategy.pay(orderPrice);
    }
}
