package com.htby.tech.kunlun.storage.bean.chunk.param;

import com.htby.tech.kunlun.runtime.web.validator.annotation.Required;
import lombok.Data;

/**
 * 分片是否存在
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class ExistsParam {

    /**
     * fileMd5
     */
    @Required(label = "文件md5不能为空")
    private String fileMd5;

    /**
     * 分片总数
     */
    @Required(label = "文件分片总数不能为空")
    private Long chunkTotal;

    /**
     * 分片编号
     */
    @Required(label = "当前分片数不能为空")
    private Long chunkNo;
}
