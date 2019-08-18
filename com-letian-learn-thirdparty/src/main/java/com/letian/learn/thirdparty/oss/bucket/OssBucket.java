package com.letian.learn.thirdparty.oss.bucket;

/**
 * @author : lh
 * @version : 1.0.0
 * @description :
 * @date :  2019-07-24 18:47
 */

public class OssBucket {


    /**
     * 桶名称
     */
    private String name;

    /**
     * 地域节点
     */
    private String endpoint;

    /**
     * 外网 Bucket 域名
     */
    private String domain;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEndpoint() {
        return endpoint;
    }

    public void setEndpoint(String endpoint) {
        this.endpoint = endpoint;
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain;
    }
}
