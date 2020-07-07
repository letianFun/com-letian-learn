package com.letian.learn.javase.design.pattern.structural.filter;

import lombok.Data;

/**
 * @author :  lihao
 * @date : 2020/7/2 13:14
 */
@Data
public class Person {

    public Person(Integer age) {
        this.age = age;
    }
    private Integer age;
}
