package com.letian.learn.util.composite;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-07-21 13:55
 */
public class CompositeValueUtil {


    /**
     * 将复合值转换成拆分后的值
     *
     * @param value 复合值
     * @param list  多个 2^n 值
     * @return null : 没有值
     * != null :  所有包含 复合值 的数(逗号间隔)
     */
    public static String splitValue(Integer value, List<Integer> list) {
        if (value == null || value == 0) {
            return null;
        }
        List<Integer> arrayList = new ArrayList<>(list);
        //存放【复合值】对应的多个【拆分值】
        List<Integer> tempList = arrayList.stream().filter(e -> (value & e) != 0).collect(Collectors.toList());
        if (tempList.isEmpty()) {
            return null;
        }
        //去除重复的值
        arrayList.removeAll(tempList);
        List<Integer> splitList = new ArrayList<>();
        splitList.add(value);
        for (int i = 0, len = arrayList.size(); i < len; i++) {
            Integer temp = value | arrayList.get(i);
            splitList.add(temp);
            for (int j = i + 1; j < len; j++) {
                splitList.add(temp | arrayList.get(j));
            }
        }
        return splitList.stream().map(String::valueOf).collect(Collectors.joining(","));
    }


//    public static void main(String[] args) {
//        System.err.println(CompositeValueUtil.splitValue(3, Lists.newArrayList(1, 2, 4, 8, 16, 32)));
//    }


}
