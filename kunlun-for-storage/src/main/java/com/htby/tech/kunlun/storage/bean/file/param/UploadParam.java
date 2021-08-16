package com.htby.tech.kunlun.storage.bean.file.param;

import com.htby.tech.kunlun.runtime.web.validator.annotation.Required;
import lombok.Data;
import org.springframework.web.multipart.MultipartFile;

/**
 * 文件上传
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class UploadParam {

    /**
     * 文件属性
     */
    @Required(label = "文件分片不允许为空")
    private MultipartFile file;

    /**
     * md5
     */
    @Required(label = "文件md5不能为空")
    private String md5;
}
