package com.jinchao.utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class TimeTest {
    public static void main(String[] args) {
        //获取系统时间是String类型
        System.out.println(new Date());
        //把系统时间转换成Date类型
        String format = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm"));
        System.out.println(format);
    }
}
