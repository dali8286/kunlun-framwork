package com.htby.tech.kunlun.audit.dao.def;

import com.htby.tech.kunlun.audit.entity.def.AuditSimpleSearchDefPO;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 审核单
 *
 * @author vincent0116
 * @date 2019/08/26
 */
@Repository
public interface AuditDefDAO {

    /**
     * 审核单查询
     *
     * @param auditModule
     * @param status
     * @return
     */
    List<AuditSimpleSearchDefPO> listAuditByCondition(@Param(value = "auditModule") Integer auditModule, @Param(value = "status") Integer status);

}
