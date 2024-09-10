package com.portal.week4;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.TimeZone;

/**
 * @title 오늘의 날짜는?
 * @url https://www.acmicpc.net/problem/16170
 * @tag 날짜, 구현
 * @since 2024-09-06
 */
public class Boj16170 {

    public static void main(String[] args) {
        Date date = new Date();
        DateFormat df = new SimpleDateFormat("YYYY-MM-dd");
        df.setTimeZone(TimeZone.getTimeZone("Asia/Seoul"));
        String now = df.format(date);
        String[] arr = now.split("-");
        System.out.println(arr[0]);
        System.out.println(arr[1]);
        System.out.println(arr[2]);
    }
}
