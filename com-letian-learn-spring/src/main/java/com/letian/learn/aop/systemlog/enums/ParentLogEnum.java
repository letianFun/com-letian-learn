package com.letian.learn.aop.systemlog.enums;

/**
 * @author Mr.Wei
 * @version 1.0.0
 * @program ParentLogEnum
 * @description 日志父类枚举
 * @date 2019-07-22
 */
public enum ParentLogEnum {

    /**
     * 父类
     */
    NOT(0, "无"),
    HOUSE(1, "房源"),

    CLIENT(2, "客源");


    private Integer key;

    private String value;

    ParentLogEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }
}
