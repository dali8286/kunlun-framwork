package com.htby.tech.kunlun.storage.dao.auto;

import com.htby.tech.kunlun.storage.entity.auto.FilePOExample;
import com.htby.tech.kunlun.storage.entity.auto.FilePO;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileDAO {
    long countByExample(FilePOExample example);

    int deleteByExample(FilePOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FilePO record);

    int insertSelective(FilePO record);

    List<FilePO> selectByExample(FilePOExample example);

    FilePO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FilePO record, @Param("example") FilePOExample example);

    int updateByExample(@Param("record") FilePO record, @Param("example") FilePOExample example);

    int updateByPrimaryKeySelective(FilePO record);

    int updateByPrimaryKey(FilePO record);
}