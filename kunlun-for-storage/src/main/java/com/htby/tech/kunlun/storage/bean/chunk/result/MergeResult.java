package com.htby.tech.kunlun.storage.bean.chunk.result;

import lombok.Data;

/**
 * 分片合并结果
 *
 * @author vincent0116
 * @date 2020/01/15
 */
@Data
public class MergeResult extends CheckFileResult{

    /**
     * 是否合并成功
     */
    private Boolean isMergeCompleted = false;
}
