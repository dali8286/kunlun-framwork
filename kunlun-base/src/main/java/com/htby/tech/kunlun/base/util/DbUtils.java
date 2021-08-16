package com.htby.tech.kunlun.base.util;

/**
 * 数据库工具类
 *
 * @author vincent0116
 * @date 2018/12/10
 */
public class DbUtils {

    /**
     * Integer转化为Boolean
     *
     * @param num
     * @return
     */
    public static Boolean int2bool(Integer num) {

        if (num.intValue() == 0) {
            return false;
        } else if (num.intValue() == 1) {
            return true;
        }
        return false;
    }
}
