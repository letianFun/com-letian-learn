package com.letian.learn.javase.design.pattern.structural.filter;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @author :  lihao
 * @date : 2020/7/2 13:21
 */
public class AgeFilter implements PersonFilter {
    @Override
    public List<Person> filter(List<Person> personList) {
        return personList.stream().filter(e-> e.getAge() > 20).collect(Collectors.toList());
    }
}
