package com.letian.learn.thirdparty.oss.util;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.letian.learn.thirdparty.oss.enums.OSSImageTypeEnum;
import com.letian.learn.thirdparty.oss.enums.OSSWaterMarkEnum;
import net.coobird.thumbnailator.Thumbnails;
import org.apache.commons.lang3.StringUtils;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;


/**
 * 图片处理工具
 *
 * @author : lh
 * @version : 1.0.0
 * @date :  2019-07-12 13:35
 */
public class OSSImageUtil {

    /**
     * 压缩原图,没有水印
     *
     * @param inputStream 图片流
     * @param imageName   图片名称
     * @return
     * @throws IOException
     */
    public static InputStream compressOriginal(InputStream inputStream, String imageName) throws IOException {
        BufferedImage image = ImageIO.read(inputStream);
        int width = image.getWidth();
        int height = image.getHeight();
        int originalWidth = OSSImageTypeEnum.ORIGINAL.getWidth();
        int originalHeight = OSSImageTypeEnum.ORIGINAL.getHeight();
        //图片的宽大于指定的宽
        if (width > originalHeight) {
            //图片的宽大于高, 宽=指定款,缩小高
            if (width > height) {
                height = originalWidth * height / width;
                width = originalWidth;
            } else if (height > width) {
                //图片的高大于宽, 高=指定高,缩小宽
                width = originalHeight * width / height;
                height = originalHeight;
            }
        }
        ByteArrayOutputStream os = new ByteArrayOutputStream();
        //文件后缀
        String suffix = StringUtils.substringAfterLast(imageName, ".");
        Thumbnails.of(image).forceSize(width, height).outputQuality(1).outputFormat(suffix).toOutputStream(os);
        return new ByteArrayInputStream(os.toByteArray());
    }

    /**
     * 处理图片水印和压缩小图
     *
     * @param ossClient        阿里云连接
     * @param bucketName       桶的名称
     * @param imagePath        图片路径(不包含特定的层级)
     * @param ossImageTypeEnum 图片大小
     * @param waterMarkEnum    水印信息();
     * @return 返回路径
     */
    public static String compressAndWatermark(OSSClient ossClient, String bucketName, String imagePath,
                                              OSSImageTypeEnum ossImageTypeEnum, OSSWaterMarkEnum waterMarkEnum) {
        //压缩
        String resize = "image/resize,m_fixed,w_" + ossImageTypeEnum.getWidth() + ",h_" + ossImageTypeEnum.getHeight();
        //水印
        String watermark = "/watermark,image_" + waterMarkEnum.getName() + ",t_" + waterMarkEnum.getT() + ",g_" + waterMarkEnum.getG();
        String originPath = OSSImageTypeEnum.ORIGINAL.getPrefix() + imagePath;
        GetObjectRequest request = new GetObjectRequest(bucketName, originPath);
        request.setProcess(resize + watermark);
        OSSObject object = ossClient.getObject(request);
        ObjectMetadata metadata = new ObjectMetadata();
        metadata.setObjectAcl(CannedAccessControlList.PublicRead);
        //将压缩的文件夹名拼接
        String path = ossImageTypeEnum.getPrefix() + imagePath;
        ossClient.putObject(bucketName, path, object.getObjectContent(), metadata);
        return path;
    }

}
