package com.tetris.djj.machine_m.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Adu on 2015/10/7.
 */
public class DateUtils {

    public static String dateFormatyMdHms(long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = new Date(time);
        return df.format(date);
    }

    public static String dateFormatyMdHm(long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Date date = new Date(time);
        return df.format(date);
    }

    public static String dateFormatMdHms(long time) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm:ss");
        Date date = new Date(time);
        return df.format(date);
    }

    public static String dateFormatMdHm(long time) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd HH:mm");
        Date date = new Date(time);
        return df.format(date);
    }

    public static String dateFormatyMd(long time) {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date(time);
        return df.format(date);
    }

    public static String dateFormatMd(long time) {
        SimpleDateFormat df = new SimpleDateFormat("MM-dd");
        Date date = new Date(time);
        return df.format(date);
    }

    public static String dateFormatHms(long time) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date(time);
        return df.format(date);
    }

    public static String dateFormatHm(long time) {
        SimpleDateFormat df = new SimpleDateFormat("HH:mm");
        Date date = new Date(time);
        return df.format(date);
    }
}
