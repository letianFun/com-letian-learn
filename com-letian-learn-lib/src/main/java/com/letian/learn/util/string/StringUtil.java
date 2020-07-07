package com.letian.learn.util.string;


import cn.hutool.core.util.StrUtil;

/**
 * @author :   lh
 * @date ：Created in 17:24 2019/1/9
 * @version : 1.0.0
 */
public class StringUtil {

//    public static void main(String[] args) {
//        System.err.println(underlineToHump("house.user_name"));
//    }

    /** 下划线转驼峰
     *       user_name  ---->  userName
     * house.user_name  ---->  userName
     *        userName   --->  userName
     * @param underlineName 带有下划线的名字
     * @return 驼峰字符串
     */
    public static String underlineToHump(String underlineName) {
        if (StrUtil.isBlank(underlineName)) {
            return null;
        }
        //截取字符串.以后的字符串
        int index = underlineName.indexOf(".");
        if (index != -1) {
            underlineName = StrUtil.subSuf(underlineName,index + 1);
        }
        //截取下划线分成数组
        char[] charArray = underlineName.toCharArray();
        //判断上次循环的字符是否是"_"
        boolean underlineBefore = false;
        StringBuffer buffer = new StringBuffer();
        for (int i = 0,l = charArray.length; i < l; i++) {
            //判断当前字符是否是"_",如果跳出本次循环
            if (charArray[i] == 95) {
                underlineBefore = true;
            } else if (underlineBefore) {
                //如果为true，代表上次的字符是"_",当前字符需要转成大写
                buffer.append(charArray[i] -= 32);
                underlineBefore = false;
            } else { //不是"_"后的字符就直接追加
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }

    /** 驼峰转 下划线
     *       userName  ---->  user_name
     *       user_name  ---->  user_name
     * @param humpName  驼峰命名
     * @return  带下滑线的String
     */
    public static String humpToUnderline(String humpName) {
        if (StrUtil.isBlank(humpName)) {
            return null;
        }
        //截取下划线分成数组，
        char[] charArray = humpName.toCharArray();
        StringBuffer buffer = new StringBuffer();
        //处理字符串
        for (int i = 0,l=charArray.length; i < l; i++) {
            if (charArray[i] >= 65 && charArray[i] <= 90) {
                buffer.append("_").append(charArray[i] += 32);
            }else {
                buffer.append(charArray[i]);
            }
        }
        return buffer.toString();
    }
}
