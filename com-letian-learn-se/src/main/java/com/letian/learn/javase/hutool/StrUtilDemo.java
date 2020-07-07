package com.letian.learn.javase.hutool;

import cn.hutool.core.util.StrUtil;

/**
 * @author :  lihao
 * @date : 2020/6/10 10:39
 * @description :
 */
public class StrUtilDemo {
    public static void main(String[] args) {
        String a = null, b = "", c = " ", d = "dddd";
        System.err.println(StrUtil.upperFirst(d));
        System.err.println(StrUtil.isAllNotBlank(d,d));



    }
}
