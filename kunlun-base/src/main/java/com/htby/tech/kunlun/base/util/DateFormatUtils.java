package com.htby.tech.kunlun.base.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期格式化工具
 *
 * @author vincent0116
 * @date 2018/12/10
 */
public class DateFormatUtils {

    /**
     * 距发布多久
     *
     * @param releaseTime
     * @return
     */
    public static String sinceToday(Date releaseTime) {

        long ONE_MINUTE = 60;
        long ONE_HOUR = 3600;
        long ONE_DAY = 86400;
        long ONE_MONTH = 2592000;
        long ONE_YEAR = 31104000;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(releaseTime);

        long time = releaseTime.getTime() / 1000;
        long now = System.currentTimeMillis() / 1000;
        long ago = now - time;
        if (ago <= ONE_HOUR) {
            return ago / ONE_MINUTE + "分钟前";
        } else if (ago <= ONE_DAY) {
            return ago / ONE_HOUR + "小时" + (ago % ONE_HOUR / ONE_MINUTE) + "分钟前";
        } else if (ago <= ONE_DAY * 2) {
            return "昨天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        } else if (ago <= ONE_DAY * 3) {
            return "前天" + calendar.get(Calendar.HOUR_OF_DAY) + "点" + calendar.get(Calendar.MINUTE) + "分";
        } else if (ago <= ONE_MONTH) {
            long day = ago / ONE_DAY;
            if (day < 7) {
                return day + "天前";
            } else if (day >= 7 && day < 14) {
                return "1周前";
            } else if (day >= 14 && day < 21) {
                return "2周前";
            } else if (day >= 21 && day < 28) {
                return "3周前";
            } else {
                return "4周前";
            }
        } else if (ago <= ONE_YEAR) {
            long month = ago / ONE_MONTH;
            long day = ago % ONE_MONTH / ONE_DAY;
            return month + "个月" + day + "天前";
        } else {
            long year = ago / ONE_YEAR;
            int month = calendar.get(Calendar.MONTH) + 1;
            return year + "年前" + month + "月" + calendar.get(Calendar.DATE)  + "日";
        }
    }

    /**
     * 距发布多久
     *
     * ＜60分钟 --- xx分钟前；
     * 1小时（含）以上24小时以内 --- xx小时前；
     * 24小时（含）以上48小时以内 --- 昨天；
     * 48小时（含）以上 --- MM-DD；
     *
     * @param releaseTime
     * @return
     */
    public static String sinceToday2(Date releaseTime) {

        long ONE_MINUTE = 60;
        long ONE_HOUR = 3600;
        long ONE_DAY = 86400;

        Calendar calendar = Calendar.getInstance();
        calendar.setTime(releaseTime);
        long time = releaseTime.getTime() / 1000;
        long now = System.currentTimeMillis() / 1000;
        long ago = now - time;

        if (ago < ONE_HOUR) {
            long flag = ago / ONE_MINUTE;
            if (flag == 0L) {
                return "刚刚";
            } else {
                return ago / ONE_MINUTE + "分钟前";
            }
        } else if (ago < ONE_DAY) {
            return ago / ONE_HOUR + "小时前";
        } else if (ago < ONE_DAY * 2) {
            return "昨天" ;
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat("MM-dd");
            return sdf.format(releaseTime);
        }
    }
}
