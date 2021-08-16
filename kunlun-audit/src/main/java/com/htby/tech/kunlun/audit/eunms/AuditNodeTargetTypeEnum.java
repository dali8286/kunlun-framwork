package com.htby.tech.kunlun.audit.eunms;

/**
 * 目标类型
 *
 * @author vicent
 * @date 2019/08/23
 */
public enum AuditNodeTargetTypeEnum {

    NONE(0, "无规则");

    private Integer type;
    private String desc;

    AuditNodeTargetTypeEnum(Integer type, String desc) {
        this.type = type;
        this.desc = desc;
    }

    public Integer getType() {
        return type;
    }

    public String getDesc() {
        return desc;
    }

    public static AuditNodeTargetTypeEnum getObjByType(Integer type) {
        for (AuditNodeTargetTypeEnum item : values()) {
            if (item.getType().intValue() == type.intValue()) {
                return AuditNodeTargetTypeEnum.NONE;
            }
        }
        return AuditNodeTargetTypeEnum.NONE;
    }
}
