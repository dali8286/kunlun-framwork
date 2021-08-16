package com.htby.tech.kunlun.platform.web.config;

import com.htby.tech.kunlun.utils.date.DateUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * json转化器
 *
 * @author vincent0116
 * @date 2018/08/18
 */
@Slf4j
public class StringToDateConveter implements Converter<String, Date> {

    @Override
    public Date convert(String input) {
        // yyyy-MM-dd HH:mm:ss
        String regexStr1 = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}:[0-9]{2}$";
        // yyyy-MM-dd
        String regexStr2 = "^[0-9]{4}-[0-9]{2}-[0-9]{2}$";
        // yyyy-MM-dd HH:mm
        String regexStr3 = "^[0-9]{4}-[0-9]{2}-[0-9]{2} [0-9]{2}:[0-9]{2}$";
        try {
            if (null != input && !"".equals(input)) {
                input = input.trim();
                boolean yyyyMmDdflag = Pattern.compile(regexStr2).matcher(input).matches();
                boolean yyyyMmDdhhmmflag = Pattern.compile(regexStr3).matcher(input).matches();
                boolean yyyyMmDdhhmmssflag = Pattern.compile(regexStr1).matcher(input).matches();
                if (yyyyMmDdflag) {
                    return DateUtils.str2date(input);
                } else if (yyyyMmDdhhmmflag) {
                    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
                    return dateFormat.parse(input);
                } else if (yyyyMmDdhhmmssflag) {
                    return DateUtils.str2time(input);
                }
            }
            return null;
        } catch (Exception e) {
            return null;
        }
    }
}
