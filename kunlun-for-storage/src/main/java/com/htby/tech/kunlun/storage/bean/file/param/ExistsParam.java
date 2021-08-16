package com.htby.tech.kunlun.storage.bean.file.param;

import com.htby.tech.kunlun.runtime.web.validator.annotation.Required;
import lombok.Data;

/**
 * 文件是否存在
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class ExistsParam {

    /**
     * md5
     */
    @Required(label = "文件md5不能为空")
    private String md5;
}
