package com.letian.learn.thirdparty.oss;

import com.aliyun.oss.OSSClient;
import com.letian.learn.thirdparty.oss.bucket.OssBucket;
import com.letian.learn.thirdparty.oss.enums.OSSBucketEnum;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @description:
 * @author: lh
 * @create: 2019-05-08 17:58
 */

@Component
@ConfigurationProperties(prefix = "oss")
public class OSSConfig {


    /**
     * 访问id
     */
    private String accessKeyId;

    /**
     * 访问秘钥
     */
    private String accessKeySecret;

    /**
     * 桶的信息
     */
    private Map<String, OssBucket> bucket;


    /**
     * 获取 连接
     *
     * @param ossBucketEnum 桶
     * @return 连接
     */
    public OSSClient getOssClient(OSSBucketEnum ossBucketEnum) {
        OssBucket ossBucket = getBucketByType(ossBucketEnum);
        return new OSSClient(ossBucket.getEndpoint(), accessKeyId, accessKeySecret);
    }

    /**
     * 获取桶
     *
     * @param bucketEnum 桶
     * @return 桶信息
     */
    public OssBucket getBucketByType(OSSBucketEnum bucketEnum) {
        return bucket.get(bucketEnum.toString().toLowerCase());
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public void setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
    }

    public void setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
    }

    public Map<String, OssBucket> getBucket() {
        return bucket;
    }

    public void setBucket(Map<String, OssBucket> bucket) {
        this.bucket = bucket;
    }

}
