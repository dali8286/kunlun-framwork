package com.htby.tech.kunlun.audit.dao.auto;

import com.htby.tech.kunlun.audit.entity.auto.AuditLogPO;
import com.htby.tech.kunlun.audit.entity.auto.AuditLogPOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditLogDAO {
    long countByExample(AuditLogPOExample example);

    int deleteByExample(AuditLogPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuditLogPO record);

    int insertSelective(AuditLogPO record);

    List<AuditLogPO> selectByExample(AuditLogPOExample example);

    AuditLogPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuditLogPO record, @Param("example") AuditLogPOExample example);

    int updateByExample(@Param("record") AuditLogPO record, @Param("example") AuditLogPOExample example);

    int updateByPrimaryKeySelective(AuditLogPO record);

    int updateByPrimaryKey(AuditLogPO record);
}