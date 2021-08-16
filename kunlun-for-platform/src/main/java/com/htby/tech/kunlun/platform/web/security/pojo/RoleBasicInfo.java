package com.htby.tech.kunlun.platform.web.security.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 角色基础信息
 *
 * @author vincent0116
 * @date 2019/07/26
 */
@Slf4j
@Data
public class RoleBasicInfo implements Serializable, Comparable {

    /**
     * 角色Id
     */
    private String roleId;

    /**
     * 角色Name
     */
    private String roleName;

    @Override
    public int compareTo(Object o) {
        RoleBasicInfo roleBasicInfo = (RoleBasicInfo) o;
        return roleId.compareTo(roleBasicInfo.getRoleId());
    }
}
