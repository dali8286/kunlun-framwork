package com.htby.tech.kunlun.audit.eunms;

/**
 * 审批流状态
 *
 * @author vincent0116
 * @date 2019/08/23
 */
public enum AuditFlowStatusEnum {

    SAVE(1, "保存"),
    OFFLINE(10, "下线"),
    ONLINE(32, "上线");

    private Integer status;
    private String desc;

    AuditFlowStatusEnum(Integer status, String desc) {
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
