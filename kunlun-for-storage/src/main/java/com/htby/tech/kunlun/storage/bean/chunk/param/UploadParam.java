package com.htby.tech.kunlun.storage.bean.chunk.param;

import com.htby.tech.kunlun.runtime.web.validator.annotation.Required;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 分片上传
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class UploadParam {

    /**
     * 文件名称
     */
    @Required(label = "文件名称不能为空")
    private String fileName;

    /**
     * 文件Md5
     */
    @Required(label = "文件md5不能为空")
    private String fileMd5;

    /**
     * 文件类型
     */
    @Required(label = "文件类型不能为空")
    private String mimeType;

    /**
     * chunkFile
     */
    @Required(label = "文件分片不允许为空")
    private MultipartFile chunkFile;

    /**
     * 分片总数
     */
    @Required(label = "分片总数不能为空")
    private Long chunkTotal;

    /**
     * 当前分片(从1开始)
     */
    @Required(label = "当前分片数不能为空")
    private long chunkNo;
}
