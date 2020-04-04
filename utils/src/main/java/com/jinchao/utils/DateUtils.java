package com.jinchao.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {
    /**
     * 日期转字符串
     *
     * @param date
     * @param patt
     * @return
     * @throws Exception
     */
    public static String date2String(Date date, String patt) {
        String format = null;
        try {
            SimpleDateFormat simpleFormatter = new SimpleDateFormat(patt);
            format = simpleFormatter.format(date);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return format;
    }

    /**
     * 字符串转日期
     *
     * @param str
     * @param patt
     * @return
     */
    public static Date string2Date(String str, String patt) throws Exception {
        Date parse = null;
        try {
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(patt);
            parse = simpleDateFormat.parse(str);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return parse;
    }
}
