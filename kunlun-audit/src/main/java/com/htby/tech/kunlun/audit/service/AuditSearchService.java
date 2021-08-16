package com.htby.tech.kunlun.audit.service;

import com.github.pagehelper.PageInfo;
import com.htby.tech.kunlun.audit.entity.def.AuditSimpleSearchDefPO;

import java.util.List;

/**
 * 审批单相关
 *
 * @author vincent0116
 * @date 2019/07/27
 */
public interface AuditSearchService {

    /**
     * 查询审批单(分页)
     *
     * @param auditModule
     * @param status
     * @param operator
     * @param start
     * @param limit
     * @return
     */
    PageInfo<AuditSimpleSearchDefPO> listAudit4PageByCondition(Integer auditModule, Integer status, String operator, Integer start, Integer limit);

    /**
     * 查询审批单
     *
     * @param auditModule
     * @param status
     * @param operator
     * @return
     */
    List<AuditSimpleSearchDefPO> listAuditByCondition(Integer auditModule, Integer status, String operator);
}
