package com.itdr.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @ClassName: timestampUtil
 * @author: heyuu
 * @create: 2019-08-05 08:56:58
 * @version: JDK 1.8
 * @description:
 */
public class TimeStampUtil {
    private static Date date = new Date();
    public static String getTimestamp(){
        long ts = date.getTime();
        String timestamp = ts+"";
        timestamp = timestamp.substring(0,10);
        timestamp = timestamp+"000";
        return timestamp;
    }
    public static String getTime(String timestamp){
        long l = Long.parseLong(timestamp);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String format = sdf.format(l);
        return format;
    }
}
