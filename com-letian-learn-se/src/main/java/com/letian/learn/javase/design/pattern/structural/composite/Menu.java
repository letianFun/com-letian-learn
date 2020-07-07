package com.letian.learn.javase.design.pattern.structural.composite;

import lombok.Data;

import java.util.List;

/**
 * @author :  lihao
 * @date : 2020/7/6 11:35
 */
@Data
public class Menu {


    private String name;

    private List<Menu> children;
}
