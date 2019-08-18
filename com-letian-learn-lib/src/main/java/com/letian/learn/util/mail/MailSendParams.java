package com.letian.learn.util.mail;

import lombok.Data;

/**
 * @desc 发送邮件参数类
 */
@Data
public class MailSendParams {

    /**
     * 发送者称呼
     */
    private String nick;

    /**
     * 发送目标邮箱地址
     */
    private String toAddress;

    /**
     * 发送内容
     */
    private String sendText;

    /**
     * 发送邮件主题
     */
    private String sendSubject;

}
