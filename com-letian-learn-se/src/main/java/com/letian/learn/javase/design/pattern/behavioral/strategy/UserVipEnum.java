package com.letian.learn.javase.design.pattern.behavioral.strategy;

/**
 * @author :  lihao
 * @date : 2020/6/30 15:47
 */
public enum UserVipEnum {

    /**
     *
     */
    VIP(1, "普通会员", "vipUser"),

    SUP_VIP(2, "超级会员", "superVipUser");

    private Integer type;

    private String desc;

    private String beanName;

    UserVipEnum(Integer type, String desc, String beanName) {
        this.type = type;
        this.desc = desc;
        this.beanName = beanName;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public String getBeanName() {
        return beanName;
    }
}
