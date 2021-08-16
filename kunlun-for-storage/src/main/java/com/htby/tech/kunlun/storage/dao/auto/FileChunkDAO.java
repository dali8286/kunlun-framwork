package com.htby.tech.kunlun.storage.dao.auto;

import com.htby.tech.kunlun.storage.entity.auto.FileChunkPO;
import com.htby.tech.kunlun.storage.entity.auto.FileChunkPOExample;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FileChunkDAO {
    long countByExample(FileChunkPOExample example);

    int deleteByExample(FileChunkPOExample example);

    int deleteByPrimaryKey(Long id);

    int insert(FileChunkPO record);

    int insertSelective(FileChunkPO record);

    List<FileChunkPO> selectByExample(FileChunkPOExample example);

    FileChunkPO selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") FileChunkPO record, @Param("example") FileChunkPOExample example);

    int updateByExample(@Param("record") FileChunkPO record, @Param("example") FileChunkPOExample example);

    int updateByPrimaryKeySelective(FileChunkPO record);

    int updateByPrimaryKey(FileChunkPO record);
}