package com.htby.tech.kunlun.audit.entity.def;

import lombok.Data;

import java.util.Date;

/**
 * 审批单
 *
 * @author vincent0116
 * @date 2019/08/28
 */
@Data
public class AuditSimpleSearchDefPO {

    /**
     * 审批单ID
     */
    private String auditId;

    /**
     * 目标ID
     */
    private String targetId;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 审批人ID
     */
    private String auditorId;

    /**
     * 审批人名称
     */
    private String auditorName;

    /**
     * 审批时间
     */
    private Date auditTime;
}
