package com.letian.learn.javase.design.pattern.structural.filter;

import cn.hutool.core.collection.CollUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author :  lihao
 * @date : 2020/7/2 13:22
 */
public class Test {
    public static void main(String[] args) {
        ArrayList<Person> arrayList = CollUtil.newArrayList(new Person(10),new Person(30));
        PersonFilter personFilter = new AgeFilter();
        List<Person> filter = personFilter.filter(arrayList);
        System.out.println(filter);
    }
}
