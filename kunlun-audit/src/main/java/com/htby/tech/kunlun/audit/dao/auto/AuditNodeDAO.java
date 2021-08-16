package com.htby.tech.kunlun.audit.dao.auto;

import com.htby.tech.kunlun.audit.entity.auto.AuditNodePO;
import com.htby.tech.kunlun.audit.entity.auto.AuditNodePOExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AuditNodeDAO {
    long countByExample(AuditNodePOExample example);

    int deleteByExample(AuditNodePOExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(AuditNodePO record);

    int insertSelective(AuditNodePO record);

    List<AuditNodePO> selectByExample(AuditNodePOExample example);

    AuditNodePO selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") AuditNodePO record, @Param("example") AuditNodePOExample example);

    int updateByExample(@Param("record") AuditNodePO record, @Param("example") AuditNodePOExample example);

    int updateByPrimaryKeySelective(AuditNodePO record);

    int updateByPrimaryKey(AuditNodePO record);
}