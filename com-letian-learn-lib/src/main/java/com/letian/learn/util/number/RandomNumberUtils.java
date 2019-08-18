package com.letian.learn.util.number;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * @program: hshb-business-manage
 * @description:
 * @author: lh
 * @date: 2018-11-29 18:49
 * @version: 1.0.0
 */
public class RandomNumberUtils {
    /**
     * 生成随机的数字加字母
     *
     * @param num ： 需要的长度
     * @return
     */
    public static String getRandomID(int num) {
        StringBuffer stringBuffer = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < num; i++) {
            String str = random.nextInt(2) % 2 == 0 ? "num" : "char";
            if ("char".equals(str)) {
                // 产生字母
                stringBuffer.append((char) (65 + random.nextInt(26)));
            } else {
                //产生数字
                stringBuffer.append(random.nextInt(10));
            }
        }
        return stringBuffer.toString();
    }

    public static List<String> getRandomNumber(int size, int num) {
        List<String> list = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            list.add(getRandomID(num));
        }
        return list;
    }


}
