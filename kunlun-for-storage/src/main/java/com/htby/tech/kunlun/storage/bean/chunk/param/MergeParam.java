package com.htby.tech.kunlun.storage.bean.chunk.param;

import com.htby.tech.kunlun.runtime.web.validator.annotation.Required;
import lombok.Data;

/**
 * 分片合并
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class MergeParam {

    /**
     * 文件名称
     */
    @Required(label = "文件名称不能为空")
    private String fileName;

    /**
     * 文件md5
     */
    @Required(label = "文件md5不能为空")
    private String fileMd5;
}
