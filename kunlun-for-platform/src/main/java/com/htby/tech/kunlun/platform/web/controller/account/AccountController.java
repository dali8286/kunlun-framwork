package com.htby.tech.kunlun.platform.web.controller.account;

import com.htby.tech.kunlun.base.enums.ApiCallReturnCodeEnum;
import com.htby.tech.kunlun.platform.bean.param.account.AccountListParam;
import com.htby.tech.kunlun.platform.bean.result.account.AccountSimpleVO;
import com.htby.tech.kunlun.platform.business.account.AccountBusiness;
import com.htby.tech.kunlun.runtime.web.bean.result.ApiBaseResult;
import com.htby.tech.kunlun.runtime.web.bean.result.ApiCallPager;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 账户相关
 *
 * @author vincent0116
 * @date 2020/03/09
 */
@Slf4j
@Api(tags = "账号相关")
@RestController
@RequestMapping("/account")
public class AccountController {

    @Resource
    private AccountBusiness accountBusiness;

    /**
     * 获取账户列表
     *
     * @param accountListParam
     * @return
     */
    @ApiOperation(value = "账号列表")
    @GetMapping("/pager/list")
    public ApiBaseResult<ApiCallPager<AccountSimpleVO>> pagerList(AccountListParam accountListParam) {

        return new ApiBaseResult<ApiCallPager<AccountSimpleVO>>(ApiCallReturnCodeEnum.SUCCESS.getCode(), ApiCallReturnCodeEnum.SUCCESS.getMessage(), accountBusiness.list(accountListParam.getStart(), accountListParam.getLimit()));
    }
}
