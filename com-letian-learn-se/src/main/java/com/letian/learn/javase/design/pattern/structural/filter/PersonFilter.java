package com.letian.learn.javase.design.pattern.structural.filter;

import java.util.List;

/**
 * @author :  lihao
 * @date : 2020/7/2 13:18
 */
public interface PersonFilter {

    List<Person> filter(List<Person> personList);
}
