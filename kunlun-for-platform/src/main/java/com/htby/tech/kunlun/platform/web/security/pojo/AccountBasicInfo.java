package com.htby.tech.kunlun.platform.web.security.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 账号基础信息
 *
 * @author vincent0116
 * @date 2019/7/27
 */
@Data
@Slf4j
public class AccountBasicInfo implements Serializable {

    /**
     * 用户ID
     */
    private String accountId;

    /***
     * 登录ID
     */
    private String sessionId;

    /**
     * 用户Name
     */
    private String accountName;

    /**
     * 头像
     */
    private String avatar;

    /**
     * 角色set
     */
    private Set<RoleBasicInfo> roleBasicInfoSet;

    /**
     * 账户资源
     */
    private ResourceBasic resourceBasic;

    /**
     * 是否拥有资源
     *
     * @param flags
     * @return
     */
    public boolean hasResource(String[] flags) {
        if (flags == null || flags.length == 0) {
            return false;
        }

        Set<ResourceBasicInfo> resourceBasicInfoAllSet = new HashSet<>();
        resourceBasicInfoAllSet.addAll(resourceBasic.getAction());
        resourceBasicInfoAllSet.addAll(resourceBasic.getPage());
        for (String flag : flags) {
            for (ResourceBasicInfo resourceBasicInfo : resourceBasicInfoAllSet) {
                if (flag.equals(resourceBasicInfo.getResourceFlag())) {
                    return true;
                }
            }
        }

        return false;
    }
}
