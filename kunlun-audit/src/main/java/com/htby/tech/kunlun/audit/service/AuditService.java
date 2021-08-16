package com.htby.tech.kunlun.audit.service;

import com.github.pagehelper.PageInfo;
import com.htby.tech.kunlun.audit.AuditCallBack;
import com.htby.tech.kunlun.audit.entity.def.AuditSimpleSearchDefPO;
import com.htby.tech.kunlun.audit.entity.auto.AuditFlowPO;
import com.htby.tech.kunlun.audit.entity.auto.AuditNodePO;
import com.htby.tech.kunlun.audit.entity.auto.AuditPO;

import java.util.List;

/**
 * 审批单相关
 *
 * @author vincent0116
 * @date 2019/07/27
 */
public interface AuditService {

    /**
     * 查询审批单
     *
     * @param auditModule
     * @param status
     * @param start
     * @param limit
     * @return
     */
    PageInfo<AuditSimpleSearchDefPO> listAudit4PageByCondition(Integer auditModule, Integer status, Integer start, Integer limit);

    /**
     * 查询审批单
     *
     * @param auditModule
     * @param status
     * @return
     */
    List<AuditSimpleSearchDefPO> listAuditByCondition(Integer auditModule, Integer status);

    /**
     * 获取审批单
     *
     * @param auditId
     * @return
     */
    AuditPO getAudit(String auditId);

    /**
     * 获取审批流
     *
     * @param auditModule
     * @return
     */
    AuditFlowPO getAuditFlowByAuditModule(Integer auditModule);

    /**
     * 获取审批流节点(audit_module)
     * @param auditModule
     * @return
     */
    AuditNodePO getAuditNodeByAuditModule(Integer auditModule);

    /**
     * 获取审批流节点(node_id)
     * @param nodeId
     * @return
     */
    AuditNodePO getAuditNodeByNodeId(String nodeId);

    /**
     * 获取审批中未关闭的审批单
     *
     * @param auditId
     * @return
     */
    AuditPO getAuditWhichNotClose(String auditId);

    /**
     * 创建审批单
     *
     * @param targetId
     * @param auditModule
     * @param operator
     * @param auditCallBack
     * @return
     */
    String create(String targetId, Integer auditModule, String operator, AuditCallBack auditCallBack);

    /**
     * 审批通过
     *     > 返回结果仅代表该过程中未发生任何异常
     *
     * @param auditId
     * @param operator
     * @param auditCallBack
     * @return
     */
    Boolean pass(String auditId, String operator, AuditCallBack auditCallBack);

    /**
     * 审批驳回
     *    > 返回结果仅代表该过程中未发生任何异常
     *
     * @param auditId
     * @param operator
     * @param auditCallBack
     * @return
     */
    Boolean reject(String auditId, String operator, AuditCallBack auditCallBack);
}
