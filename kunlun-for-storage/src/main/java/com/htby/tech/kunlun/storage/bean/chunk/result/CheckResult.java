package com.htby.tech.kunlun.storage.bean.chunk.result;

import lombok.Data;

/**
 * 分片是否存在结果
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class CheckResult {

    /**
     * 分片是否存在
     */
    public Boolean isChunkExists = false;
}
