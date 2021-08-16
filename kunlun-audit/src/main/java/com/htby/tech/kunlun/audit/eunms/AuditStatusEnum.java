package com.htby.tech.kunlun.audit.eunms;

/**
 * 审核状态
 *
 * @author vicent
 * @date 2019/08/23
 */
public enum AuditStatusEnum {

    INIT(1, "未提审"),
    AUDITING(10, "审核中"),
    FAIL(15, "审核失败"),
    SUCCESS(32, "审核通过");

    private Integer status;
    private String desc;

    AuditStatusEnum(Integer status, String desc) {
        this.status = status;
        this.desc = desc;
    }

    public Integer getStatus() {
        return status;
    }

    public String getDesc() {
        return desc;
    }
}
