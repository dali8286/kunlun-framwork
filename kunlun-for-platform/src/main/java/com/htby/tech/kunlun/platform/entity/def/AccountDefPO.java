package com.htby.tech.kunlun.platform.entity.def;

import com.htby.tech.kunlun.runtime.db.entity.BasePO;
import lombok.Data;

/**
 * 账户信息
 *
 * @author vincent0116
 * @date 2019/07/29
 */
@Data
public class AccountDefPO extends BasePO {

    /**
     * 账号ID
     */
    private String accountId;

    /**
     * 账号名称
     */
    private String accountName;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 手机
     */
    private String mobile;
}
