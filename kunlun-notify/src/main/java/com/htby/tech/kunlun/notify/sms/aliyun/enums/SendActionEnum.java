package com.htby.tech.kunlun.notify.sms.aliyun.enums;

/**
 * 发送动作
 *
 * @author vincent0116
 * @date 2018/12/10
 */
public enum SendActionEnum {

    SMS("SendSms");

    private String action;

    SendActionEnum(String action) {
        this.action = action;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }
}
