package com.htby.tech.kunlun.audit.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.htby.tech.kunlun.audit.dao.def.AuditDefDAO;
import com.htby.tech.kunlun.audit.entity.def.AuditSimpleSearchDefPO;
import com.htby.tech.kunlun.audit.service.AuditSearchService;
import com.htby.tech.kunlun.runtime.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 审批单服务
 *
 * @author vincent0116
 * @date 2019/07/27
 */
@Slf4j
@Service
public class AuditSearchServiceImpl extends BaseService implements AuditSearchService {

    @Resource
    private AuditDefDAO auditDefDAO;

    @Override
    public PageInfo<AuditSimpleSearchDefPO> listAudit4PageByCondition(Integer auditModule, Integer status, String operator, Integer start, Integer limit) {
        //TODO 按照规则进行适配
        Page<AuditSimpleSearchDefPO> page = PageHelper.startPage(start, limit);

        List<AuditSimpleSearchDefPO> auditSimpleVOList = auditDefDAO.listAuditByCondition(auditModule, status);
        PageInfo<AuditSimpleSearchDefPO> pageInfo = new PageInfo<AuditSimpleSearchDefPO>(page);
        pageInfo.setList(auditSimpleVOList);
        return pageInfo;
    }

    @Override
    public List<AuditSimpleSearchDefPO> listAuditByCondition(Integer auditModule, Integer status, String operator) {
        //TODO 按照规则进行适配
        return auditDefDAO.listAuditByCondition(auditModule, status);
    }
}
