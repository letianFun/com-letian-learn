package com.letian.learn.javase.annotation.updaterecord;

/**
 * @author lh
 * @description
 * @create 2019-07-11 11:46
 */
public enum UserSexEnum {

    /**
     *
     */
    MAN(1, "男"),
    WOMAN(2, "女");

    private Integer key;

    private String value;

    UserSexEnum(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    @UpdateRecordMethod
    public static String getvalueByKey(Integer key) {
        for (UserSexEnum sexEnum : UserSexEnum.values()) {
            if (sexEnum.getKey().equals(key)) {
                return sexEnum.getValue();
            }

        }
        return "";
    }
}
