package com.htby.tech.kunlun.platform.web.security.pojo;

import lombok.Data;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * 账户资源
 *
 * @author vincent0116
 * @date 2019/07/27
 */
@Data
public class ResourceBasic implements Serializable {

    /**
     * 操作类权限set
     */
    private Set<ResourceBasicInfo> action = new HashSet<>();

    /**
     * 页面类权限set
     */
    private Set<ResourceBasicInfo> page = new HashSet<>();
}
