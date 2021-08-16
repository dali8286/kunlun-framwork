package com.htby.tech.kunlun.audit.dao.auto;

import com.htby.tech.kunlun.audit.entity.auto.AuditPO;
import com.htby.tech.kunlun.audit.entity.auto.AuditPOExample;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuditDAO {
    long countByExample(AuditPOExample example);

    int deleteByExample(AuditPOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuditPO record);

    int insertSelective(AuditPO record);

    List<AuditPO> selectByExample(AuditPOExample example);

    AuditPO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuditPO record, @Param("example") AuditPOExample example);

    int updateByExample(@Param("record") AuditPO record, @Param("example") AuditPOExample example);

    int updateByPrimaryKeySelective(AuditPO record);

    int updateByPrimaryKey(AuditPO record);
}