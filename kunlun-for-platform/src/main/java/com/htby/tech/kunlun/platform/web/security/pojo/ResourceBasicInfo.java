package com.htby.tech.kunlun.platform.web.security.pojo;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;

/**
 * 资源基础信息
 *
 * @author vincent0116
 * @date 2019/07/26
 */
@Slf4j
@Data
public class ResourceBasicInfo implements Serializable, Comparable {

    /**
     * 资源Id
     */
    private String resourceId;

    /**
     * 资源Name
     */
    private String resourceName;

    /**
     * 资源标志位
     */
    private String resourceFlag;

    /**
     * 资源Type
     */
    private Integer resourceType;

    @Override
    public int compareTo(Object o) {
        ResourceBasicInfo resourceBasicInfo = (ResourceBasicInfo) o;
        return resourceId.compareTo(resourceBasicInfo.getResourceId());
    }
}
