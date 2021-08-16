package com.htby.tech.kunlun.audit.eunms;

/**
 * 审核模块
 *
 * @author vicent
 * @date 2019/08/23
 */
public enum AuditModuleEnum {

    COMMENT_HEAD(1, "评论审核"),
    COMMENT_FOLLOW(2, "跟帖审核");

    private Integer module;
    private String desc;

    AuditModuleEnum(Integer module, String desc) {
        this.module = module;
        this.desc = desc;
    }

    public Integer getModule() {
        return module;
    }

    public String getDesc() {
        return desc;
    }

    public static AuditModuleEnum getObjByType(Integer module) {
        for (AuditModuleEnum item : values()) {
            if (item.getModule().intValue() == module.intValue()) {
                return AuditModuleEnum.COMMENT_HEAD;
            }
        }
        return AuditModuleEnum.COMMENT_HEAD;
    }
}
