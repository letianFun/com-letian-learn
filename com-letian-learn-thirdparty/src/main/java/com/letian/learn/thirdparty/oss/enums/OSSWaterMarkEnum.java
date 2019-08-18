package com.letian.learn.thirdparty.oss.enums;

/**
 * @author lh
 * @description
 * @create 2019-07-22 11:14
 */
public enum OSSWaterMarkEnum {


    /**
     * 水印暂时写死,(可根据公司进行维护不同的水印图片)
     */
    HSHB_1X("d2F0ZXJtYXJrL2hzaGItMXgucG5n", 30, "center"),
    HSHB_2X("d2F0ZXJtYXJrL2hzaGItMngucG5n", 30, "center"),
    HSHB_3X("d2F0ZXJtYXJrL2hzaGItM3gucG5n", 30, "center");

    /**
     * 水印名称进行 安全Base64编码得到  SafeBase64Util.safeEncode(name);
     */
    private String name;

    /**
     * 图片水印透明度
     */
    private Integer t;


    /**
     * https://help.aliyun.com/document_detail/44957.html?spm=a2c4g.11186623.6.1398.23bfc1f6ifJDrh
     * 水印位置  [nw,north,ne,west,center,east,sw,south,se]
     */
    private String g;

    OSSWaterMarkEnum(String name, Integer t, String g) {
        this.name = name;
        this.t = t;
        this.g = g;
    }

    public String getName() {
        return name;
    }

    public Integer getT() {
        return t;
    }

    public String getG() {
        return g;
    }
}
