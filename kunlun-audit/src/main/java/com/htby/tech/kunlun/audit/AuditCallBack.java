package com.htby.tech.kunlun.audit;

/**
 * 审批回调
 *
 * @author vincent0116
 * @date 2018/12/10
 */
public interface AuditCallBack {

    /**
     * 审批创建
     *
     * @param auditId
     * @param targetId
     * @param auditModule
     * @param operator
     */
    void create(String auditId, String targetId, Integer auditModule, String operator);

    /**
     * 审核驳回
     *
     * @param targetId
     * @param auditModule
     * @param isContinue
     * @param operator
     */
    void reject(String targetId, Integer auditModule, Boolean isContinue, String operator);

    /**
     * 审核通过
     *
     * @param targetId
     * @param auditModule
     * @param isContinue
     * @param operator
     */
    void pass(String targetId, Integer auditModule, Boolean isContinue, String operator);
}
