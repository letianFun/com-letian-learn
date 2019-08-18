package com.letian.learn.util.capacity;

/**
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-06-28 16:39
 */
public class CapacityUtils {


    /**
     *  HashMap 的  负载因子
     */
    private static final float DEFAULT_LOAD_FACTOR = 0.75f;

    /** 获取初始化的 HashMap
     *
     * @param initial  逻辑初始大小
     * @return  HashMap
     */
    public static int getHashMapCapacity(int initial){
        return (int) Math.ceil(initial / DEFAULT_LOAD_FACTOR) + 1;
    }
}
