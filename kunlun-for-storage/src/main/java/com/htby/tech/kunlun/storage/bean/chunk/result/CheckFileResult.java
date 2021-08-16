package com.htby.tech.kunlun.storage.bean.chunk.result;

import lombok.Data;

/**
 * 文件是否存在结果
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class CheckFileResult {

    /**
     * 文件是否存在
     */
    public Boolean isFileExists = false;
    
    /**
     * 文件key
     */
    private String fileKey = "";

    /**
     * 文件路径
     */
    private String filePath = "";
}
