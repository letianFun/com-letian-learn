package com.letian.learn.util.http;

import org.springframework.http.HttpHeaders;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author lh
 * @description
 * @create 2019-05-22 11:51
 */
public class HttpHeadersUtil {


    /** 将对象类中的非空属性,放入到HTTPHeader里面
     *
     * @param headers
     * @param object
     * @return
     */
    public static HttpHeaders addHttpHeadersByObject(HttpHeaders headers, Object object){
        try {
            Field[] fields = getAllFields(object);
            for (int i = 0; i < fields.length; i++) {
                Field f = fields[i];
                f.setAccessible(true);
                if (f.get(object) == null) {
                    continue;
                }
                headers.add(f.getName(), f.get(object).toString());
            }
            return headers;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /** 得到对象继承的属性   (调用此方法,不能再子类初始化的时候,创建父类的对象)
     *
     * @param object
     * @return
     */
    public static Field[] getAllFields(Object object){
        Class clazz = object.getClass();
        List<Field> fieldList = new ArrayList<>();
        while (clazz != null){
            fieldList.addAll(new ArrayList<>(Arrays.asList(clazz.getDeclaredFields())));
            clazz = clazz.getSuperclass();
        }
        Field[] fields = new Field[fieldList.size()];
        fieldList.toArray(fields);
        return fields;
    }
}
