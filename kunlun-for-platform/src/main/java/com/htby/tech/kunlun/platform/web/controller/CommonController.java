package com.htby.tech.kunlun.platform.web.controller;

import com.htby.tech.kunlun.base.enums.ApiCallReturnCodeEnum;
import com.htby.tech.kunlun.runtime.web.bean.result.ApiBaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * error
 *
 * @author vincent0116
 * @date 2018/10/26
 */
@Slf4j
@RestController
public class CommonController {

    @GetMapping("/403")
    @ResponseBody
    public ApiBaseResult Error403() {
        return new ApiBaseResult(ApiCallReturnCodeEnum.FORBIDDEN.getCode(), ApiCallReturnCodeEnum.FORBIDDEN.getMessage(), null);
    }

    @GetMapping("/404")
    @ResponseBody
    public ApiBaseResult Error404() {
        return new ApiBaseResult(ApiCallReturnCodeEnum.NOT_FOUND.getCode(), ApiCallReturnCodeEnum.NOT_FOUND.getMessage(), null);
    }

    @GetMapping("/500")
    @ResponseBody
    public ApiBaseResult Error500() {
        return new ApiBaseResult(ApiCallReturnCodeEnum.ERROR.getCode(), ApiCallReturnCodeEnum.ERROR.getMessage(), null);
    }
}
