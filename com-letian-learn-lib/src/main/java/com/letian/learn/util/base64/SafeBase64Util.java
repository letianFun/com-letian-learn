package com.letian.learn.util.base64;

import sun.misc.BASE64Encoder;


/**
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-07-22 10:51
 */
public class SafeBase64Util {


    /**
     * 先将内容编码成Base64结果;
     * 将结果中的加号”+”替换成中划线“-“;
     * 将结果中的斜杠”/”替换成下划线”_”;
     * 将结果中尾部的“=”号全部保留;
     *
     * @param name
     * @return
     */
    public static String safeEncode(String name) {
        String encodeBase64 = new BASE64Encoder().encode(name.getBytes());
        String safeBase64Str = encodeBase64.replace('+', '-');
        safeBase64Str = safeBase64Str.replace('/', '_');
        safeBase64Str = safeBase64Str.replaceAll("=", "");
        return safeBase64Str;

    }

    public static void main(String[] args) {
        System.err.println(SafeBase64Util.safeEncode("watermark/hshb-1x.png"));
    }
}
