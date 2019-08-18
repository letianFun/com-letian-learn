package com.letian.learn.javase.annotation.updaterecord;

/**
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-07-11 09:22
 */
public class User {


    @UpdateRecord("姓名:")
    private String name;

    @UpdateRecord("年龄:")
    private Integer age;

    @UpdateRecord(value = "性别:", methodClass = UserSexEnum.class)
    private Integer sex;

    public User() {
    }

    public User(String name, Integer age, Integer sex) {
        this.name = name;
        this.age = age;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }
}
