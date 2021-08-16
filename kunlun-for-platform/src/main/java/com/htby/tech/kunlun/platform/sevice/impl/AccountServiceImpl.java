package com.htby.tech.kunlun.platform.sevice.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.htby.tech.kunlun.platform.dao.def.AccountDefDAO;
import com.htby.tech.kunlun.platform.entity.def.AccountDefPO;
import com.htby.tech.kunlun.platform.sevice.AccountService;
import com.htby.tech.kunlun.runtime.base.service.BaseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 账号服务
 *
 * @author vincent0116
 * @date 2020/03/09
 */
@Slf4j
@Service
public class AccountServiceImpl extends BaseService implements AccountService {

    @Resource
    private AccountDefDAO accountDefDAO;

    @Override
    public PageInfo<AccountDefPO> listAccount(Integer start, Integer limit) {
        Page<AccountDefPO> page = PageHelper.startPage(start, limit);

        List<AccountDefPO> accountDefPOList = accountDefDAO.selAccount();
        PageInfo<AccountDefPO> pageInfo = new PageInfo<AccountDefPO>(page);
        pageInfo.setList(accountDefPOList);
        return pageInfo;
    }
}
