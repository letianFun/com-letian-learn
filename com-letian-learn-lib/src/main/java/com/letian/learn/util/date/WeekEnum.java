package com.letian.learn.util.date;

/**
 *  星期枚举  用于把星期的小写转换为大写
 * @date 2019-06-23 10:50
 */
public enum WeekEnum {
    /**/
    MONDAY(1, "星期一"),
    TUESDAY(2, "星期二"),
    WEDNESDAY(3, "星期三"),
    THURSDAY(4, "星期四"),
    FRIDAY(5, "星期五"),
    SATURDAY(6, "星期六"),
    SUNDAY(7, "星期日");
    private Integer key;
    private String value;

    WeekEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    public static String getValueByKey(Integer key) {
        for (WeekEnum takeLookTypeEnum : WeekEnum.values()) {
            if (takeLookTypeEnum.getKey().equals(key)) {
                return takeLookTypeEnum.getValue();
            }
        }
        return "";
    }

}
