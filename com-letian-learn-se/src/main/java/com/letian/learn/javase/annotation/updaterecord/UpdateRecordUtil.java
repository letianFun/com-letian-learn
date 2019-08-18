package com.letian.learn.javase.annotation.updaterecord;

import org.springframework.cglib.beans.BeanMap;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * 修改记录工具类(支持基础数据的包装类,不支持集合类型的判断)
 *
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-07-11 11:39
 */
public class UpdateRecordUtil {

    /**
     * 如果 v 的字段不为null 则 set 至 t
     *
     * @param oldObj 修改前对象
     * @param newObj 修改后对象
     */
    public static <O, N> String getUpdateRecode(O oldObj, N newObj) {
        Class<?> objObjClass = oldObj.getClass();
        Class<?> newObjClass = newObj.getClass();
        if (newObjClass != objObjClass) {
            throw new RuntimeException("类文件不一致");
        }
        Field[] newObjFields = newObjClass.getDeclaredFields();
        StringBuilder builder = new StringBuilder();
        try {
            for (Field field : newObjFields) {
                //判断当前字段是否有 修改记录注解
                UpdateRecord updateRecord = field.getAnnotation(UpdateRecord.class);
                if (updateRecord != null) {
                    field.setAccessible(true);
                    Class enumClass = updateRecord.methodClass();
                    Class<?> fieldType = field.getType();
                    Object oldFieldValue = field.get(oldObj);
                    Object newFieldValue = field.get(newObj);
                    if (enumClass == UpdateRecord.class) {
                        if (fieldType == String.class) {
                            if (isAppendString(oldFieldValue.toString(), newFieldValue.toString())) {
                                appendUpdateRecord(builder, oldFieldValue.toString(), newFieldValue.toString(), updateRecord);
                            }
                        } else {
                            if (!objectIsEquals(oldFieldValue, newFieldValue)) {
                                appendUpdateRecord(builder, oldFieldValue.toString(), newFieldValue.toString(), updateRecord);
                            }
                        }
                    } else {
                        if (fieldType == String.class) {
                            if (isAppendString(oldFieldValue.toString(), newFieldValue.toString())) {
                                dealFieldByMethod(oldObj, newObj, oldFieldValue, newFieldValue, enumClass, builder, updateRecord);
                            }
                        } else {
                            if (!objectIsEquals(oldFieldValue, newFieldValue)) {
                                dealFieldByMethod(oldObj, newObj, oldFieldValue, newFieldValue, enumClass, builder, updateRecord);
                            }
                        }
                    }
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        String record = builder.toString();
        if (record.length() != 0) {
            return record.substring(0, record.length() - 1) + ";";
        }
        return null;
    }

    public static void main(String[] args) {
        User before = new User("张三", 17, null);
        User after = new User("张四", 17, 2);
       // System.out.println(getUpdateRecode(before, after));
        BeanMap beanMap = BeanMap.create(before);
        System.err.println(beanMap);
    }


    private static void appendUpdateRecord(StringBuilder builder, String oldFieldValue, String newFieldValue, UpdateRecord updateRecord) {
        builder.append(updateRecord.value()).append(updateRecord.pre()).append(oldFieldValue).append(updateRecord.suf()).append(updateRecord.change())
                .append(updateRecord.pre()).append(newFieldValue).append(updateRecord.suf()).append(updateRecord.character());
    }

    private static boolean isAppendString(String oldFieldValue, String newFieldValue) {
        if (isEmptyString(newFieldValue) && isEmptyString(oldFieldValue)) {
            return false;
        }
        return !newFieldValue.equals(oldFieldValue);
    }

    private static boolean isEmptyString(String str) {
        return str == null || str.length() == 0;
    }

    private static boolean objectIsEquals(Object a, Object b) {
        if (a == null && b == null) {
            return true;
        }
        return a != null && a.equals(b);
    }

    private static void dealFieldByMethod(Object oldObj, Object newObj, Object oldFieldValue, Object newFieldValue, Class enumClass, StringBuilder builder, UpdateRecord updateRecord) {
        Method[] methods = enumClass.getMethods();
        for (Method method : methods) {
            method.setAccessible(true);
            UpdateRecordMethod recordEnum = method.getAnnotation(UpdateRecordMethod.class);
            try {
                if (recordEnum != null) {
                    Object oldValue = method.invoke(oldObj, oldFieldValue);
                    Object newValue = method.invoke(newObj, newFieldValue);
                    appendUpdateRecord(builder, oldValue.toString(), newValue.toString(), updateRecord);
                    return;
                }
            } catch (InvocationTargetException | IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }




}
