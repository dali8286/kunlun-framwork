package com.htby.tech.kunlun.platform.web.controller;

import com.htby.tech.kunlun.base.enums.ApiCallReturnCodeEnum;
import com.htby.tech.kunlun.runtime.web.bean.result.ApiBaseResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

/**
 * monitor
 *
 * @author vincent0116
 * @date 2018/9/3
 */
@Slf4j
@RestController
@RequestMapping("/monitor")
public class MonitorController {

    /**
     * 应用监控接口
     *
     * @return
     */
    @GetMapping(value = "/index")
    @ResponseBody
    public ApiBaseResult execute(){
        return new ApiBaseResult(ApiCallReturnCodeEnum.SUCCESS.getCode(), ApiCallReturnCodeEnum.SUCCESS.getMessage(), null);
    }
}
