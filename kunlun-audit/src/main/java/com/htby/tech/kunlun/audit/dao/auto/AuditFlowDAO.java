package com.htby.tech.kunlun.audit.dao.auto;

import com.htby.tech.kunlun.audit.entity.auto.AuditFlowPO;
import com.htby.tech.kunlun.audit.entity.auto.AuditFlowPOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditFlowDAO {
    long countByExample(AuditFlowPOExample example);

    int deleteByExample(AuditFlowPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuditFlowPO record);

    int insertSelective(AuditFlowPO record);

    List<AuditFlowPO> selectByExample(AuditFlowPOExample example);

    AuditFlowPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuditFlowPO record, @Param("example") AuditFlowPOExample example);

    int updateByExample(@Param("record") AuditFlowPO record, @Param("example") AuditFlowPOExample example);

    int updateByPrimaryKeySelective(AuditFlowPO record);

    int updateByPrimaryKey(AuditFlowPO record);
}