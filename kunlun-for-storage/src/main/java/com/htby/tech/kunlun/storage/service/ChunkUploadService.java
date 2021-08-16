package com.htby.tech.kunlun.storage.service;

import com.htby.tech.kunlun.storage.bean.chunk.result.CheckFileResult;
import com.htby.tech.kunlun.storage.bean.chunk.result.CheckResult;
import com.htby.tech.kunlun.storage.bean.chunk.result.UploadResult;
import org.springframework.web.multipart.MultipartFile;

/**
 * 分片上传
 *        服务
 *
 * @author vincent0116
 * @date 2020/01/14
 */
public interface ChunkUploadService {

    /**
     * 执行
     *    分片上传
     *
     * @param fileName
     * @param fileMd5
     * @param mimeType
     * @param chunkFile
     * @param chunkTotal
     * @param chunkNo
     * @return
     */
    UploadResult doUpload(String fileName, String fileMd5, String mimeType, MultipartFile chunkFile, Long chunkTotal, Long chunkNo);

    /**
     * 执行
     *    检查分片是否存在
     *
     * @param fileMd5
     * @param chunkTotal
     * @param chunkNo
     * @return
     */
    CheckResult doCheckExists(String fileMd5, Long chunkTotal, Long chunkNo);

    /**
     * 执行
     *    检查文件是否存在
     *
     * @param fileMd5
     * @return
     */
    CheckFileResult doCheckFileExists(String fileMd5);
}
