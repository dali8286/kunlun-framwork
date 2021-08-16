package com.htby.tech.kunlun.platform.dao.def;

import com.htby.tech.kunlun.platform.entity.def.AccountDefPO;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 账号相关查询
 *
 * @author vincent0116
 * @date 2020/03/09
 */
@Repository
public interface AccountDefDAO {

    /**
     * 获取现有账号列表
     *
     * @return
     */
    List<AccountDefPO> selAccount();
}
