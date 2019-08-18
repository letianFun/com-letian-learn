package com.letian.learn.thirdparty.oss.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lh
 * @description
 * @create 2019-07-22 14:51
 */
public enum OldImageTypeEnum {

    /**
     *
     */
    ORIGINAL(""),

    /**
     * 原图加水印
     */
    WATERMARK("0000"),

    /**
     * 小图
     */
    S1("_s1"),

    /**
     * 中图
     */
    S2("_s2"),

    /**
     * 中图
     */
    S3("_s2");

    private String suffix;

    public String getSuffix() {
        return suffix;
    }

    OldImageTypeEnum(String suffix) {
        this.suffix = suffix;
    }

    /**
     * @param imagePath        原图路径
     * @param oldImageTypeEnum 照片类型
     * @return
     */
    public static String getPathBySize(String imagePath, OldImageTypeEnum oldImageTypeEnum) {
        if (StringUtils.isEmpty(imagePath)) {
            return imagePath;
        }
        if (ORIGINAL == oldImageTypeEnum) {
            return imagePath;
        }
        int index = imagePath.lastIndexOf('.');
        if (index == -1) {
            return imagePath;
        }
        String pathName = imagePath.substring(0, index);
        String suffix = imagePath.substring(index);
        return pathName + oldImageTypeEnum.suffix + suffix;
    }

}
