package com.htby.tech.kunlun.platform.business.account;

import com.github.pagehelper.PageInfo;
import com.htby.tech.kunlun.platform.bean.result.account.AccountSimpleVO;
import com.htby.tech.kunlun.platform.entity.def.AccountDefPO;
import com.htby.tech.kunlun.platform.sevice.AccountService;
import com.htby.tech.kunlun.runtime.base.business.BaseBusiness;
import com.htby.tech.kunlun.runtime.web.bean.result.ApiCallPager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 账号相关业务
 *
 * @author vincent0116
 * @date 2020/03/09
 */
@Slf4j
@Component
public class AccountBusiness extends BaseBusiness {

    @Resource
    private AccountService accountService;

    /**
     * 账号列表数据
     *
     * @param start
     * @param limit
     * @return
     */
    public ApiCallPager<AccountSimpleVO> list(Integer start, Integer limit) {
        List<AccountSimpleVO> resultList = new ArrayList<>();

        PageInfo<AccountDefPO> accountDefPOPageInfo = accountService.listAccount(start, limit);
        accountDefPOPageInfo.getList().forEach(item -> {
            AccountSimpleVO accountSimpleVO = new AccountSimpleVO();
            BeanUtils.copyProperties(item, accountSimpleVO);

            resultList.add(accountSimpleVO);
        });
        return new ApiCallPager<AccountSimpleVO>(accountDefPOPageInfo.getTotal(), resultList);
    }
}
