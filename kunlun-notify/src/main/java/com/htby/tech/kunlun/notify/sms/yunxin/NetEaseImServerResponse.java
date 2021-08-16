package com.htby.tech.kunlun.notify.sms.yunxin;

import lombok.Data;

/**
 * notify SmsInfo
 *
 * @author vincent0116
 * @date 2018/12/11
 */
@Data
public class NetEaseImServerResponse {

    /**
     * 返回码
     */
    private int code;

    /**
     * 提示语
     */
    private String msg;

    /**
     * 内容
     */
    private String obj;
}
