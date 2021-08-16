package com.htby.tech.kunlun.platform.web.security.annotation;

import java.lang.annotation.*;

/**
 * 检查Action所需的Resource
 *
 * @author vincent0116
 * @date 2019/01/20
 */
@Target({ElementType.TYPE, ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CheckRes4Action {

    /**
     * 资源标示位
     *
     * @return
     */
    String[] flags();

    /**
     * 描述(注释,便于解释)
     *
     * @return
     */
    String desc() default "";
}
