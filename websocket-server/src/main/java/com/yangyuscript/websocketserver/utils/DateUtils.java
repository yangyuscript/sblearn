package com.yangyuscript.websocketserver.utils;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author yangyuscript
 * @date: 17:34 2018/11/13
 **/
public class DateUtils {
    public static String getTimeYYYYmmDDHHMMSS() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}
