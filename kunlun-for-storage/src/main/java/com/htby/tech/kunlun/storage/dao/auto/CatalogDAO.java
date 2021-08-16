package com.htby.tech.kunlun.storage.dao.auto;

import com.htby.tech.kunlun.storage.entity.auto.CatalogPOExample;
import com.htby.tech.kunlun.storage.entity.auto.CatalogPO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface CatalogDAO {
    long countByExample(CatalogPOExample example);

    int deleteByExample(CatalogPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(CatalogPO record);

    int insertSelective(CatalogPO record);

    List<CatalogPO> selectByExample(CatalogPOExample example);

    CatalogPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") CatalogPO record, @Param("example") CatalogPOExample example);

    int updateByExample(@Param("record") CatalogPO record, @Param("example") CatalogPOExample example);

    int updateByPrimaryKeySelective(CatalogPO record);

    int updateByPrimaryKey(CatalogPO record);
}