package com.letian.learn.javase.design.pattern.behavioral.strategy;

import jdk.nashorn.internal.objects.annotations.Getter;

/**
 * @author :  lihao
 * @date : 2020/6/30 15:41
 */
public class User {

    /**
     * 用户的会员等级(数据库取出)
     */
    private Integer vipType;

    public User(Integer vipType) {
        this.vipType = vipType;
    }

    public Integer getVipType() {
        return vipType;
    }

    public void setVipType(Integer vipType) {
        this.vipType = vipType;
    }
}
