package com.letian.learn.aop.systemlog.enums;

/**
 * @author Mr.Wei
 * @version 1.0.0
 * @program ChildrenLogEnum
 * @description 日志子类
 * @date 2019-07-22
 */
public enum ChildrenLogEnum {


    /**
     * 子类
     */
    NOT(0, "无", 0),
    EVALUATE(1, "评价", 1),
    KEY(2, "钥匙", 1),
    HOUSE_INFO(3, "房源信息", 1),
    APPOINTMENT(4, "预约摄影", 1),
    NEW_HOUSE(5, "新房", 1),
    IMAGE(6, "照片", 1),
    VR(7, "VR", 1),
    VIDEO(8, "视频", 1),
    ENTRUST(9, "委托", 1),
    LIMIT_TIME(10, "限时", 1),
    ;

    private Integer key;

    private String value;

    private Integer type;

    ChildrenLogEnum(Integer key, String value, Integer type) {
        this.key = key;
        this.value = value;
        this.type = type;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public Integer getType() {
        return type;
    }
}
