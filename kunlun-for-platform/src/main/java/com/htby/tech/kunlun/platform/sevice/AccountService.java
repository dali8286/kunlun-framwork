package com.htby.tech.kunlun.platform.sevice;

import com.github.pagehelper.PageInfo;
import com.htby.tech.kunlun.platform.entity.def.AccountDefPO;

/**
 * 账号相关查询
 *
 * @author vincent0116
 * @date 2020/03/09
 */
public interface AccountService {

    /**
     * 获取账号
     *
     * @param start
     * @param limit
     * @return
     */
    PageInfo<AccountDefPO> listAccount(Integer start, Integer limit);

}
