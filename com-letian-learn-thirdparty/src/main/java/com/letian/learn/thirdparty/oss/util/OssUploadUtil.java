package com.letian.learn.thirdparty.oss.util;


import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.CannedAccessControlList;
import com.aliyun.oss.model.GetObjectRequest;
import com.aliyun.oss.model.OSSObject;
import com.aliyun.oss.model.ObjectMetadata;
import com.letian.learn.thirdparty.oss.OSSConfig;
import com.letian.learn.thirdparty.oss.bucket.OssBucket;
import com.letian.learn.thirdparty.oss.enums.OSSBucketEnum;
import com.letian.learn.thirdparty.oss.enums.OSSImageTypeEnum;
import com.letian.learn.thirdparty.oss.enums.OSSWaterMarkEnum;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URL;
import java.net.URLEncoder;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;


/**
 * @author lh
 * @description
 * @create 2019-05-15 16:27
 */
@Component
public class OssUploadUtil {


    private static Logger logger = LoggerFactory.getLogger(OssUploadUtil.class);

    /**
     * 创建缓存区的大小
     */
    private static final int BUFFER_SIZE = 4096;

    @Autowired
    private OSSConfig ossConfig;


    /**
     * 重新生文件名
     *
     * @param fileName 带有后缀的文件名
     * @return 重新生成的文件名
     */
    private String getPathByFileName(String fileName) {
        String dir = LocalDate.now().format(DateTimeFormatter.ofPattern("yyyy/MM/dd/"));
        String name = UUID.randomUUID().toString();
        String suffix = StringUtils.substringAfterLast(fileName, ".");
        return dir + name + "." + suffix;
    }


    /**
     * 取域名后的文件名称
     *
     * @param filePath 文件的全部路径
     * @return 去除域名后的路径
     */
    public String getSubFilePathByDomainName(String filePath, OSSBucketEnum ossBucketEnum) {
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);
        return StringUtils.substringAfter(filePath, bucketByType.getDomain());
    }

    /**
     * 上传文件 （公共读）
     *
     * @param file          文件流
     * @param ossBucketEnum 上传至哪一个bucket中
     * @return
     */
    public String uploadFileForPublicRead(MultipartFile file, OSSBucketEnum ossBucketEnum) {
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);

        // 创建OSSClient实例。
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        InputStream inputStream = null;
        try {
            //文件后缀
            String path = getPathByFileName(file.getOriginalFilename());
            inputStream = file.getInputStream();
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setObjectAcl(CannedAccessControlList.PublicRead);
            ossClient.putObject(bucketByType.getName(), path, inputStream, metadata);
            return bucketByType.getDomain() + path;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传文件错误:[{}]", e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * 从目录读取，不通过前端上传
     *
     * @param name
     * @param ossBucketEnum
     * @return
     */
    public String uploadFile(String name, OSSBucketEnum ossBucketEnum) {
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);
        // 创建OSSClient实例。
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        InputStream inputStream = null;
        try {
            //文件后缀
            String path = getPathByFileName(name);
            inputStream = new FileInputStream(name);
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setObjectAcl(CannedAccessControlList.Default);
            ossClient.putObject(bucketByType.getName(), path, inputStream, metadata);
            ossClient.shutdown();
            return bucketByType.getDomain() + path;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传文件错误:[{}]", e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.shutdown();
        }
        return null;
    }

    /**
     * 下载文件 至web
     *
     * @param ossBucketEnum 上传时的bucket名称
     * @param filePath      文件名称(带有文件夹名)
     * @param response      响应流
     * @return 下载结果
     */
    public boolean downLoadFile(OSSBucketEnum ossBucketEnum, String filePath, HttpServletResponse response) {
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        boolean objectExist = ossClient.doesObjectExist(new GetObjectRequest(bucketByType.getName(), filePath));
        if (!objectExist) {
            return false;
        }
        OutputStream outputStream = null;
        InputStream inputStream = null;
        try {
            String fileName = URLEncoder.encode(StringUtils.substringAfterLast(filePath, "/"), "UTF-8");
            OSSObject ossObject = ossClient.getObject(bucketByType.getName(), filePath);
            inputStream = ossObject.getObjectContent();
            response.setHeader("Content-disposition", "attachment;filename=" + fileName);
            response.setHeader("fileName", fileName);
            response.setHeader("Access-Control-Expose-Headers", "fileName,Content-disposition");
            // 不同类型的文件对应不同的MIME类型
            //response.setContentType("application/x-msdownload");
            outputStream = response.getOutputStream();
            byte[] buffer = new byte[1024];
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                outputStream.write(buffer, 0, length);
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("下载文件错误", e.getMessage());
        } finally {
            try {
                if (outputStream != null) {
                    outputStream.close();
                }
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.shutdown();
        }
        return false;
    }


    /**
     * 返回File，上传完毕后删除临时文件 下载pdf无法读流
     *
     * @param ossBucketEnum 桶
     * @param filePath      文件名称(带有文件夹名)
     * @return File
     */
    public File downLoad(OSSBucketEnum ossBucketEnum, String filePath) {
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);
        boolean objectExist = ossClient.doesObjectExist(new GetObjectRequest(bucketByType.getName(), filePath));
        if (!objectExist) {
            return null;
        }
        InputStream inputStream = null;
        OutputStream out = null;
        File file = null;
        try {
            //创建临时文件
            file =new  File("C:\\Users\\admin\\Desktop\\template\\"+filePath.substring(filePath.lastIndexOf("/") + 1));
            OSSObject ossObject = ossClient.getObject(bucketByType.getName(), filePath);
            inputStream = ossObject.getObjectContent();
            byte[] buffer = new byte[1024];
            //输出路径
            out = new FileOutputStream(file);
            int length;
            while ((length = inputStream.read(buffer)) > 0) {
                out.write(buffer, 0, length);
            }
            return file;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("下载文件错误", e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.shutdown();
        }
        return file;
    }


    /**
     * 删除文件
     *
     * @param ossBucketEnum 上传时的bucket名称
     * @param fileName      文件名称(带有文件夹名)
     * @return 删除结果
     */
    public boolean deleteFile(OSSBucketEnum ossBucketEnum, String fileName) {
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        try {
            //是否存在
            if (ossClient.doesObjectExist(new GetObjectRequest(bucketByType.getName(), fileName))) {
                ossClient.deleteObject(bucketByType.getName(), fileName);
                return true;
            }
        } catch (Exception e) {
            logger.error("删除文件错误", e.getMessage());
            e.printStackTrace();
        } finally {
            ossClient.shutdown();
        }
        return false;
    }

    /**
     * 多个文件压缩包下载(阿里云)
     *
     * @param ossBucketEnum    上传时的bucket名称
     * @param fileNameList     文件名称集合(带有文件夹名)
     * @param compressFileName 压缩包的名称(必须带有后缀,如:test.zip)
     * @param response         响应流
     * @return 下载结果
     */
    public boolean downLoadCompressOSSFile(String compressFileName, List<String> fileNameList, OSSBucketEnum ossBucketEnum, HttpServletResponse response) {
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        byte[] buf = new byte[BUFFER_SIZE];
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(response.getOutputStream());
            compressFileName = URLEncoder.encode(compressFileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + compressFileName);
            response.setHeader("fileName", compressFileName);
            response.setHeader("Access-Control-Expose-Headers", "fileName,Content-disposition");
            for (String filePath : fileNameList) {
                String fileName = StringUtils.substringAfterLast(filePath, "/");
                out.putNextEntry(new ZipEntry(fileName));
                InputStream in = ossClient.getObject(bucketByType.getName(), filePath).getObjectContent();
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            return true;
        } catch (IOException e) {
            logger.error("下载压缩文件错误:[{}]", e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                logger.error("下载压缩文件错误:[{}]", e.getMessage());
            }
            ossClient.shutdown();
        }
        return false;
    }

    /**
     * 多个文件压缩包下载(阿里云和老服务器)
     *
     * @param ossBucketEnum    上传时的bucket名称
     * @param fileNameList     文件名称集合(带有文件夹名)
     * @param compressFileName 压缩包的名称(必须带有后缀,如:test.zip)
     * @param response         响应流
     * @return 下载结果
     */
    public boolean downLoadCompressFile(String compressFileName, List<String> fileNameList, OSSBucketEnum ossBucketEnum, String oldDomainURL, HttpServletResponse response) {
        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        byte[] buf = new byte[BUFFER_SIZE];
        ZipOutputStream out = null;
        try {
            out = new ZipOutputStream(response.getOutputStream());
            compressFileName = URLEncoder.encode(compressFileName, "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename=" + compressFileName);
            response.setHeader("fileName", compressFileName);
            response.setHeader("Access-Control-Expose-Headers", "fileName,Content-disposition");
            for (String filePath : fileNameList) {
                InputStream in;
                //老服务器
                if (filePath.contains(oldDomainURL)) {
                    URL url = new URL(filePath);
                    in = new DataInputStream(url.openStream());
                } else if (filePath.contains(bucketByType.getDomain())) {
                    //阿里云服务器
                    in = ossClient.getObject(bucketByType.getName(), filePath).getObjectContent();
                } else {
                    continue;
                }
                String fileName = StringUtils.substringAfterLast(filePath, "/");
                out.putNextEntry(new ZipEntry(fileName));
                int len;
                while ((len = in.read(buf)) > 0) {
                    out.write(buf, 0, len);
                }
                out.closeEntry();
                in.close();
            }
            return true;
        } catch (IOException e) {
            logger.error("下载压缩文件错误:[{}]", e.getMessage());
        } finally {
            try {
                if (out != null) {
                    out.close();
                }
            } catch (IOException e) {
                logger.error("下载压缩文件错误:[{}]", e.getMessage());
            }
            ossClient.shutdown();
        }
        return false;
    }


    /**
     * 上传文件 （公共读）
     *
     * @param file          文件流
     * @param ossBucketEnum 上传至哪一个bucket中
     * @return
     */
    public String uploadImageResizeAndWatermark(MultipartFile file, OSSBucketEnum ossBucketEnum) {

        OssBucket bucketByType = ossConfig.getBucketByType(ossBucketEnum);

        // 创建OSSClient实例。
        OSSClient ossClient = ossConfig.getOssClient(OSSBucketEnum.TEST);
        InputStream inputStream = null;
        try {
            //文件后缀
            String path = getPathByFileName(file.getOriginalFilename());
            //压缩图片大小,上传原图
            inputStream = OSSImageUtil.compressOriginal(file.getInputStream(), path);
            //设置权限并上传原图
            ObjectMetadata metadata = new ObjectMetadata();
            metadata.setObjectAcl(CannedAccessControlList.Private);
            ossClient.putObject(bucketByType.getName(), OSSImageTypeEnum.ORIGINAL.getPrefix() + path, inputStream, metadata);
            //上传水印原图
            String originPath = OSSImageUtil.compressAndWatermark(ossClient, bucketByType.getName(), path, OSSImageTypeEnum.ORIGINAL_WATERMARK, OSSWaterMarkEnum.HSHB_3X);
            //上传水印中图
            OSSImageUtil.compressAndWatermark(ossClient, bucketByType.getName(), path, OSSImageTypeEnum.MIDDLE_WATERMARK, OSSWaterMarkEnum.HSHB_2X);
            //上传水印小图
            OSSImageUtil.compressAndWatermark(ossClient, bucketByType.getName(), path, OSSImageTypeEnum.SMALL_WATERMARK, OSSWaterMarkEnum.HSHB_1X);
            return bucketByType.getDomain() + originPath;
        } catch (Exception e) {
            e.printStackTrace();
            logger.error("上传文件错误:[{}]", e.getMessage());
        } finally {
            try {
                if (inputStream != null) {
                    inputStream.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
            ossClient.shutdown();
        }
        return null;
    }
}
