package com.letian.learn.aop.systemlog.enums;

/**
 * @author Mr.Wei
 * @version 1.0.0
 * @program OperatingLogEnum
 * @description 所有日志增删改查使用 操作类型
 * @date 2019-07-22
 */
public enum OperatingLogEnum {

    /**
     * 增删改查
     */
    INSERT(1, "添加"),

    DELETE(2, "删除"),

    UPDATE(3, "修改"),

    SELECT(4, "查询"),

    AUDIT(5, "审核"),
    APPEAL(6, "申诉"),
    DOWNLOAD(7, "下载");

    private Integer key;

    private String value;

    OperatingLogEnum(Integer key, String value) {
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
