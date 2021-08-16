package com.htby.tech.kunlun.storage.helper;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * 存储配置类
 *
 * @author vincent0116
 * @date 2020/01/14
 */
@Data
@Configuration
public class StorageConfigure {

    @Value("${upload.chunk.parent.dir}")
    private String uploadChunkParentDir;

    @Value("${upload.chunk.file.ext}")
    private String uploadChunkFileExt;

    @Value("${upload.file.parent.dir}")
    private String uploadFileParentDir;

    @Value("${upload.file.host}")
    private String uploadFileHost;
}
