package com.htby.tech.kunlun.storage.web.controller.upload;

import com.htby.tech.kunlun.storage.bean.file.param.UploadParam;
import com.htby.tech.kunlun.base.enums.ApiCallReturnCodeEnum;
import com.htby.tech.kunlun.runtime.web.bean.result.ApiBaseResult;
import com.htby.tech.kunlun.runtime.web.validator.FormValidator;
import com.htby.tech.kunlun.storage.bean.file.param.ExistsParam;
import org.springframework.web.bind.annotation.*;

/**
 * file-upload
 *
 * @author vincent0116
 * @date 2020/01/14
 */
@RequestMapping(value = "/file")
@RestController
public class FileUploadController {

    /**
     * 文件上传
     *
     * @param uploadParam
     * @return
     */
    @PostMapping("/upload")
    public ApiBaseResult upload(UploadParam uploadParam) {
        FormValidator.validateByAnnotation(uploadParam);

        return new ApiBaseResult(ApiCallReturnCodeEnum.SUCCESS.getCode(), ApiCallReturnCodeEnum.SUCCESS.getMessage(), null);
    }

    /**
     * 文件是否存在
     *
     * @param existsParam
     * @return
     */
    @GetMapping("/exists")
    public ApiBaseResult exists(ExistsParam existsParam) {
        FormValidator.validateByAnnotation(existsParam);

        return new ApiBaseResult(ApiCallReturnCodeEnum.SUCCESS.getCode(), ApiCallReturnCodeEnum.SUCCESS.getMessage(), null);
    }
}
