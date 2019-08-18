package com.letian.learn.thirdparty.oss.util;


import com.letian.learn.thirdparty.oss.enums.OSSImageTypeEnum;
import com.letian.learn.thirdparty.oss.enums.OldImageTypeEnum;
import org.apache.commons.lang3.StringUtils;

/**
 * @author : lh
 * @version : 1.0.0
 * @description : 替换显示的图片路径
 * @date :  2019-08-11 10:32
 */
public class ImagePathUtil {

    private static final String OLD_IMAGE_DOMAIN = "http://img.hshb.cn";


    /**
     * 转换图片的路径
     *
     * @param imagePath        图片路径
     * @param oldImageTypeEnum 老服务图片的大小
     * @param ossImageTypeEnum OSS 图片的大小
     * @return
     */
    public static String getPathByType(String imagePath, OldImageTypeEnum oldImageTypeEnum, OSSImageTypeEnum ossImageTypeEnum) {
        if (isOldImageDomain(imagePath)) {
            return OldImageTypeEnum.getPathBySize(imagePath, oldImageTypeEnum);
        }
        return OSSImageTypeEnum.getPathBySize(imagePath, ossImageTypeEnum);
    }

    public static boolean isOldImageDomain(String imagePath) {
        if (StringUtils.isEmpty(imagePath)) {
            return false;
        }
        return imagePath.contains(OLD_IMAGE_DOMAIN);
    }

    public static String getOldImageDomain() {
        return OLD_IMAGE_DOMAIN;
    }
}
