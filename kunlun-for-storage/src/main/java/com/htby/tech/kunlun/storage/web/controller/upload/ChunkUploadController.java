package com.htby.tech.kunlun.storage.web.controller.upload;

import com.htby.tech.kunlun.base.enums.ApiCallReturnCodeEnum;
import com.htby.tech.kunlun.runtime.web.bean.result.ApiBaseResult;
import com.htby.tech.kunlun.runtime.web.validator.FormValidator;
import com.htby.tech.kunlun.storage.bean.chunk.param.ExistsParam;
import com.htby.tech.kunlun.storage.bean.chunk.param.FileExistsParam;
import com.htby.tech.kunlun.storage.bean.chunk.param.UploadParam;
import com.htby.tech.kunlun.storage.bean.chunk.result.CheckFileResult;
import com.htby.tech.kunlun.storage.bean.chunk.result.CheckResult;
import com.htby.tech.kunlun.storage.bean.chunk.result.UploadResult;
import com.htby.tech.kunlun.storage.service.ChunkUploadService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * chunk-upload
 *
 * @author vincent0116
 * @date 2020/01/14
 */
@RequestMapping(value = "/chunk")
@RestController
public class ChunkUploadController {

    @Resource
    private ChunkUploadService chunkUploadService;

    /**
     * 分片上传
     *
     * @param uploadParam
     * @return
     */
    @PostMapping("/upload")
    public ApiBaseResult upload(UploadParam uploadParam) {
        FormValidator.validateByAnnotation(uploadParam);

        UploadResult result = chunkUploadService.doUpload(uploadParam.getFileName(), uploadParam.getFileMd5(), uploadParam.getMimeType(), uploadParam.getChunkFile(), uploadParam.getChunkTotal(), uploadParam.getChunkNo());
        return new ApiBaseResult(ApiCallReturnCodeEnum.SUCCESS.getCode(), ApiCallReturnCodeEnum.SUCCESS.getMessage(), result);
    }

    /**
     * 分片是否存在
     *
     * @param existsParam
     * @return
     */
    @GetMapping("/exists")
    public ApiBaseResult exists(ExistsParam existsParam) {
        FormValidator.validateByAnnotation(existsParam);

        CheckResult result = chunkUploadService.doCheckExists(existsParam.getFileMd5(), existsParam.getChunkTotal(), existsParam.getChunkNo());
        return new ApiBaseResult(ApiCallReturnCodeEnum.SUCCESS.getCode(), ApiCallReturnCodeEnum.SUCCESS.getMessage(), result);
    }

    /**
     * 文件是否存在
     *
     * @param fileExistsParam
     * @return
     */
    @GetMapping("/file/exists")
    public ApiBaseResult exists(FileExistsParam fileExistsParam) {
        FormValidator.validateByAnnotation(fileExistsParam);

        CheckFileResult result = chunkUploadService.doCheckFileExists(fileExistsParam.getFileMd5());
        return new ApiBaseResult(ApiCallReturnCodeEnum.SUCCESS.getCode(), ApiCallReturnCodeEnum.SUCCESS.getMessage(), result);
    }
}
