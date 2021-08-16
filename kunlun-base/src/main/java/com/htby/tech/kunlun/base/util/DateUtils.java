package com.htby.tech.kunlun.base.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

/**
 * 日期工具类
 *
 * @author vincent0116
 * @date 2018/12/11
 */
public class DateUtils {

    /**
     * 获取当天00:00
     *
     * @param date
     * @return
     */
    public static Date zeroTime(Date date) {
        long current = date.getTime();

        return new Date(current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset());
    }

    /**
     * 获取当天23:59
     *
     * @param date
     * @return
     */
    public static Date endTime(Date date)  {
        long current = date.getTime();
        long zeroTime = current/(1000*3600*24)*(1000*3600*24)- TimeZone.getDefault().getRawOffset();

        return new Date(zeroTime+24*60*60*1000-1);
    }

    /**
     * 加一天
     *
     * @param date
     * @return
     */
    public static Date addMinutes(Date date, int minutes) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MINUTE, minutes);

        return calendar.getTime();
    }

    /**
     * 加一天
     *
     * @param date
     * @return
     */
    public static Date addOneDay(Date date) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.DAY_OF_MONTH, 1);

        return calendar.getTime();
    }

    /**
     * date 转化为 utc
     *
     * @param date
     * @return
     */
    public static String date2Utc(Date date) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'");
        return sdf.format(date);
    }
}
