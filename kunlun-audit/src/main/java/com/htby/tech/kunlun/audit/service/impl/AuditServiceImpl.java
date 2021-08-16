package com.htby.tech.kunlun.audit.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.htby.tech.kunlun.utils.uuid.UuidUtils;
import com.htby.tech.kunlun.audit.AuditCallBack;
import com.htby.tech.kunlun.audit.dao.def.AuditDefDAO;
import com.htby.tech.kunlun.audit.entity.def.AuditSimpleSearchDefPO;
import com.htby.tech.kunlun.audit.dao.auto.AuditDAO;
import com.htby.tech.kunlun.audit.dao.auto.AuditFlowDAO;
import com.htby.tech.kunlun.audit.dao.auto.AuditLogDAO;
import com.htby.tech.kunlun.audit.dao.auto.AuditNodeDAO;
import com.htby.tech.kunlun.audit.entity.auto.*;
import com.htby.tech.kunlun.audit.eunms.AuditFlowStatusEnum;
import com.htby.tech.kunlun.audit.eunms.AuditNodeTargetTypeEnum;
import com.htby.tech.kunlun.audit.eunms.AuditStatusEnum;
import com.htby.tech.kunlun.audit.service.AuditService;
import com.htby.tech.kunlun.runtime.base.exception.InternalException;
import com.htby.tech.kunlun.runtime.base.service.BaseService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 审批单服务
 *
 * @author vincent0116
 * @date 2019/07/27
 */
@Slf4j
@Service
public class AuditServiceImpl extends BaseService implements AuditService {

    @Resource
    private AuditDefDAO auditDefDAO;
    @Resource
    private AuditDAO auditDAO;
    @Resource
    private AuditFlowDAO auditFlowDAO;
    @Resource
    private AuditLogDAO auditLogDAO;
    @Resource
    private AuditNodeDAO auditNodeDAO;

    @Override
    public PageInfo<AuditSimpleSearchDefPO> listAudit4PageByCondition(Integer auditModule, Integer status, Integer start, Integer limit) {
        //TODO 按照规则进行适配
        Page<AuditSimpleSearchDefPO> page = PageHelper.startPage(start, limit);

        List<AuditSimpleSearchDefPO> auditSimpleVOList = auditDefDAO.listAuditByCondition(auditModule, status);
        PageInfo<AuditSimpleSearchDefPO> pageInfo = new PageInfo<AuditSimpleSearchDefPO>(page);
        pageInfo.setList(auditSimpleVOList);
        return pageInfo;
    }

    @Override
    public List<AuditSimpleSearchDefPO> listAuditByCondition(Integer auditModule, Integer status) {
        //TODO 按照规则进行适配
        return auditDefDAO.listAuditByCondition(auditModule, status);
    }

    @Override
    public AuditPO getAudit(String auditId) {
        AuditPOExample auditPOExample = new AuditPOExample();
        auditPOExample.createCriteria().andAuditIdEqualTo(auditId).andIsDelEqualTo(tinyIntToByte(0));
        List<AuditPO> auditPOList = auditDAO.selectByExample(auditPOExample);
        if (auditPOList == null || auditPOList.size() <= 0) {
            throw new InternalException("审批单不存在,操作失败");
        }
        return auditPOList.get(0);
    }

    @Override
    public AuditFlowPO getAuditFlowByAuditModule(Integer auditModule) {
        AuditFlowPOExample auditFlowPOExample = new AuditFlowPOExample();
        auditFlowPOExample.createCriteria().andAuditModuleEqualTo(auditModule.byteValue()).andStatusEqualTo(AuditFlowStatusEnum.ONLINE.getStatus().byteValue()).andIsDelEqualTo(tinyIntToByte(0));
        List<AuditFlowPO> auditFlowPOList = auditFlowDAO.selectByExample(auditFlowPOExample);
        if (auditFlowPOList == null || auditFlowPOList.size() <= 0) {
            throw new InternalException("审批流不存在,操作失败");
        }
        return auditFlowPOList.get(0);
    }

    @Override
    public AuditNodePO getAuditNodeByAuditModule(Integer auditModule) {
        AuditFlowPO auditFlowPO = getAuditFlowByAuditModule(auditModule);

        AuditNodePOExample auditNodePOExample = new AuditNodePOExample();
        auditNodePOExample.createCriteria().andFlowIdEqualTo(auditFlowPO.getFlowId()).andParentIdEqualTo("-1").andIsDelEqualTo(tinyIntToByte(0));
        List<AuditNodePO> auditNodePOList = auditNodeDAO.selectByExample(auditNodePOExample);
        if (auditNodePOList == null || auditNodePOList.size() <= 0) {
            throw new InternalException("审批流节点不存在,操作失败");
        }
        return auditNodePOList.get(0);
    }

    @Override
    public AuditNodePO getAuditNodeByNodeId(String nodeId) {
        AuditNodePOExample auditNodePOExample = new AuditNodePOExample();
        auditNodePOExample.createCriteria().andNodeIdEqualTo(nodeId).andIsDelEqualTo(tinyIntToByte(0));
        List<AuditNodePO> auditNodePOList = auditNodeDAO.selectByExample(auditNodePOExample);
        if (auditNodePOList == null || auditNodePOList.size() <= 0) {
            throw new InternalException("审批流节点不存在,操作失败");
        }
        return auditNodePOList.get(0);
    }

    @Override
    public AuditPO getAuditWhichNotClose(String auditId) {
        AuditPOExample auditPOExample = new AuditPOExample();
        auditPOExample.createCriteria().andAuditIdEqualTo(auditId).andStatusEqualTo(tinyIntToByte(AuditStatusEnum.AUDITING.getStatus())).andIsCloseEqualTo(tinyIntToByte(0)).andIsDelEqualTo(tinyIntToByte(0));
        List<AuditPO> auditPOList = auditDAO.selectByExample(auditPOExample);
        if (auditPOList == null || auditPOList.size()<= 0) {
            throw new InternalException("不存在审核中未关闭的审核单,操作失败");
        }
        return auditPOList.get(0);
    }

    @Override
    public String create(String targetId, Integer auditModule, String operator, AuditCallBack auditCallBack) {
        String auditId = UuidUtils.getUUID();
        String nodeId = getAuditNodeByAuditModule(auditModule).getNodeId();

        AuditFlowPO auditFlowPO = getAuditFlowByAuditModule(auditModule);
        insertInfo(auditId, targetId, nodeId, auditModule, auditFlowPO.getFlowId(), operator);
        insertLog(auditId, nodeId, AuditStatusEnum.AUDITING.getStatus(), operator);

        if (auditCallBack != null) {
            auditCallBack.create(auditId, targetId, auditModule, operator);
        }
        return auditId;
    }

    @Override
    public Boolean pass(String auditId, String operator, AuditCallBack auditCallBack) {
        Boolean result = true;
        try {
            AuditPO auditPO = getAuditWhichNotClose(auditId);
            String flowId = auditPO.getFlowId();
            String preNodeId = auditPO.getNodeId();
            String targetId = auditPO.getTargetId();
            Integer auditModule = auditPO.getAuditModule().intValue();

            NextAuditNodeItem nextAuditNodeItem = calculateNextNode(flowId, preNodeId);
            Integer isLast = nextAuditNodeItem.getIsLast();
            String nodeId = nextAuditNodeItem.getNodeId();
            if (isLast.intValue() == 1) {
                auditPO.setStatus(AuditStatusEnum.SUCCESS.getStatus().byteValue());
                auditPO.setIsClose(tinyIntToByte(1));
            }
            auditPO.setNodeId(nodeId);
            auditPO.setMender(operator);
            auditPO.setUpdateTime(new Date());
            auditDAO.updateByPrimaryKeySelective(auditPO);

            insertLog(auditId, nodeId, AuditStatusEnum.SUCCESS.getStatus(), operator);

            if (auditCallBack != null) {
                if (isLast.intValue() == 1) {
                    auditCallBack.pass(targetId, auditModule, false, operator);
                } else {
                    auditCallBack.pass(targetId, auditModule, true, operator);
                }
            }
        } catch (Exception e) {
            log.error("审批通过过程发生错误", e);
            result = false;
        }
        return result;
    }

    @Override
    public Boolean reject(String auditId, String operator, AuditCallBack auditCallBack) {
        Boolean result = true;
        try {
            AuditPO auditPO = getAuditWhichNotClose(auditId);
            String targetId = auditPO.getTargetId();
            Integer auditModule = auditPO.getAuditModule().intValue();
            String curNodeId = auditPO.getNodeId();
            log.info("reject-targetId:{},curNodeId:{};", targetId, curNodeId);

            AuditNodePO auditNodePO = getAuditNodeByNodeId(curNodeId);
            if (auditNodePO == null) {
                throw new InternalException("当前审批节点不存在，操作失败");
            }

            Integer isReverse = auditNodePO.getIsReverse().intValue();
            if (isReverse.intValue() == 1) {
                String nodeId = calculatePreNode(auditId);

                auditPO.setStatus(AuditStatusEnum.AUDITING.getStatus().byteValue());
                auditPO.setNodeId(nodeId);
                auditPO.setIsClose(tinyIntToByte(0));
                auditPO.setMender(operator);
                auditPO.setUpdateTime(new Date());
                auditDAO.updateByPrimaryKeySelective(auditPO);

                insertLog(auditId, nodeId, AuditStatusEnum.AUDITING.getStatus(), operator);
                if (auditCallBack != null) {
                    auditCallBack.reject(targetId, auditModule, true, operator);
                }
            } else {
                auditPO.setStatus(AuditStatusEnum.FAIL.getStatus().byteValue());
                auditPO.setIsClose(tinyIntToByte(1));
                auditPO.setMender(operator);
                auditPO.setUpdateTime(new Date());
                auditDAO.updateByPrimaryKeySelective(auditPO);

                insertLog(auditId, "", AuditStatusEnum.FAIL.getStatus(), operator);
                if (auditCallBack != null) {
                    auditCallBack.reject(targetId, auditModule, false, operator);
                }
            }
        } catch (Exception e) {
            log.error("审批驳回过程发生错误", e);
            result = false;
        }
        return result;
    }

    /**
     * 添加审批单
     *
     * @param auditId
     * @param targetId
     * @param nodeId
     * @param auditModule
     * @param flowId
     * @param operator
     * @return
     */
    public int insertInfo(String auditId, String targetId, String nodeId, Integer auditModule, String flowId, String operator) {
        AuditPO auditPO = new AuditPO();
        auditPO.setAuditId(auditId);
        auditPO.setTargetId(targetId);
        auditPO.setAuditModule(auditModule.byteValue());
        auditPO.setFlowId(flowId);
        auditPO.setNodeId(nodeId);
        auditPO.setIsClose(tinyIntToByte(0));
        auditPO.setStatus(AuditStatusEnum.AUDITING.getStatus().byteValue());
        auditPO.setCreator(operator);
        auditPO.setMender(operator);
        auditPO.setCreateTime(new Date());
        auditPO.setUpdateTime(new Date());

        return auditDAO.insertSelective(auditPO);
    }

    /**
     * 添加审批单日志
     *
     * @param auditId
     * @param nodeId
     * @param status
     * @param operator
     * @return
     */
    public int insertLog(String auditId, String nodeId, Integer status, String operator) {
        AuditLogPO auditLogPO = new AuditLogPO();
        auditLogPO.setAuditId(auditId);
        auditLogPO.setNodeId(nodeId);
        auditLogPO.setStatus(status.byteValue());
        auditLogPO.setCreator(operator);
        auditLogPO.setCreateTime(new Date());
        auditLogPO.setIsDel(tinyIntToByte(0));
        return auditLogDAO.insertSelective(auditLogPO);
    }

    /**
     * 计算pre审批流节点
     *
     * @param auditId
     * @return
     */
    private String calculatePreNode(String auditId) {
        AuditLogPOExample auditLogPOExample = new AuditLogPOExample();
        auditLogPOExample.setOrderByClause("create_time desc");
        auditLogPOExample.createCriteria().andAuditIdEqualTo(auditId).andStatusEqualTo(tinyIntToByte(AuditStatusEnum.SUCCESS.getStatus())).andIsDelEqualTo(tinyIntToByte(0));
        List<AuditLogPO> auditLogPOList = auditLogDAO.selectByExample(auditLogPOExample);
        if (auditLogPOList == null || auditLogPOList.size() <= 0) {
            throw new InternalException("审批记录不存在,请联系管理员处理");
        }

        AuditLogPO auditLogPO = auditLogPOList.get(0);
        return auditLogPO.getNodeId();
    }

    /**
     * 计算next审批流节点
     *
     * @param flowId
     * @param nodeId
     * @return
     */
    private NextAuditNodeItem calculateNextNode(String flowId, String nodeId) {
        NextAuditNodeItem nextAuditNodeItem = new NextAuditNodeItem();

        AuditNodePOExample auditNodePOExample = new AuditNodePOExample();
        auditNodePOExample.createCriteria().andFlowIdEqualTo(flowId).andParentIdEqualTo(nodeId).andIsDelEqualTo(tinyIntToByte(0));
        List<AuditNodePO> auditNodePOList = auditNodeDAO.selectByExample(auditNodePOExample);
        if (auditNodePOList == null || auditNodePOList.size() <= 0) {
            throw new InternalException("审核单对应的节点不存在,请联系管理员处理");
        }

        if (auditNodePOList.size() == 1) {
            AuditNodePO auditNodePO = auditNodePOList.get(0);
            nextAuditNodeItem.setNodeId(auditNodePO.getNodeId());
            nextAuditNodeItem.setIsLast(auditNodePO.getIsLast().intValue());
        } else {
            //TODO 一分多模式(根据当前人来判断,如果当前人同时存在多个节点中还是会存在问题,必须业务上限制)
            for (AuditNodePO auditNodePO : auditNodePOList) {
                switch (AuditNodeTargetTypeEnum.getObjByType(auditNodePO.getTargetType().intValue())) {
                    case NONE:
                        nextAuditNodeItem.setNodeId(auditNodePO.getNodeId());
                        nextAuditNodeItem.setIsLast(auditNodePO.getIsLast().intValue());
                        break;
                    default:
                        throw new InternalException(new StringBuffer("暂时无法匹配[").append(auditNodePO.getTargetType()).append("]类型,待业务兼容").toString());
                }
            }
        }
        return nextAuditNodeItem;
    }

    @Data
    public class NextAuditNodeItem {

        /**
         * 节点ID
         */
        private String nodeId;

        /**
         * 是否为最终节点
         */
        private Integer isLast;
    }

    @Data
    public class PreNodeItem {

        /**
         * 节点ID
         */
        private String nodeId;

        /**
         * 是否为逆转节点
         */
        private Integer isReverse;
    }
}
