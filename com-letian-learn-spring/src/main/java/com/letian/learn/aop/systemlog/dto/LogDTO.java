package com.letian.learn.aop.systemlog.dto;

import lombok.Data;

@Data
public class LogDTO {

    /**
     * 租户ID
     */
    private Long companyId;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 用户姓名
     */
    private String userName;

    /**
     * 终端类别 0-ERP 1-APP 3-管理后端
     */
    private Integer terminalType;

    /**
     * 终端设备ID
     */
    private String terminalId;

    /**
     * 日志父类模块
     */
    private Integer parentType;


    /**
     * 日志子类模块
     */
    private Integer childrenType;


    /**
     * 操作类型  增 删 改 查
     */
    private Integer operatingType;


    /**
     * 日志事件
     */
    private Integer eventName;

    /**
     * 日志内容
     */
    private String content;

    /**
     * 日志回溯路径
     */
    private String recallPath;


    /**
     * 日志参数
     */
    private String logParameter;

    /**
     * 执行时间 (毫秒)
     */
    private Long executeTime;

}
