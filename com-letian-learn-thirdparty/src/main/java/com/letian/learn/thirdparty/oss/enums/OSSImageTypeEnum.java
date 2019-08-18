package com.letian.learn.thirdparty.oss.enums;

import org.apache.commons.lang3.StringUtils;

/**
 * @author lh
 * @description
 * @create 2019-07-22 14:51
 */
public enum OSSImageTypeEnum {


    /**
     * 上传压缩后的原图
     */
    ORIGINAL("original/", 1333, 1000),

    /**
     * 原图加水印
     */
    ORIGINAL_WATERMARK("o-wm/", 1333, 1000),
    /**
     * 中图加水印
     */
    MIDDLE_WATERMARK("m-wm/", 400, 300),
    /**
     * 小图加水印
     */
    SMALL_WATERMARK("s-wm/", 200, 150);


    private String prefix;

    private Integer width;

    private Integer height;

    private


    OSSImageTypeEnum(String prefix, Integer width, Integer height) {
        this.prefix = prefix;
        this.width = width;
        this.height = height;
    }

    public String getPrefix() {
        return prefix;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }


    public static String getPathBySize(String path, OSSImageTypeEnum ossImageTypeEnum) {
        if (StringUtils.isEmpty(path)) {
            return null;
        }
        for (OSSImageTypeEnum value : OSSImageTypeEnum.values()) {
            if (path.contains(value.getPrefix())) {
                return path.replace(value.getPrefix(), ossImageTypeEnum.getPrefix());
            }
        }
        return path;
    }
}
