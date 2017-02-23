package com.bb.hbx.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2017/2/22.
 */

public class TimeUtils {

    public  static String getDateToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sf.format(d);
    }

    public  static String getDateNoHourToString(long time) {
        Date d = new Date(time);
        SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        return sf.format(d);
    }

    //将字符串转为时间戳
    public static long getStringToDate(String time) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        try {
            date = sdf.parse(time);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
}
