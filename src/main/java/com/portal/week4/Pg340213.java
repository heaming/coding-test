package com.portal.week4;

/**
 * @title PCCP 1 - 동영상 재생기
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/340213
 * @tag
 * @since 2024-09-08
 */
public class Pg340213 {
//    class Solution {

    static int stringToTime(String s) {
        String[] arr = s.split(":");
        return Integer.parseInt(arr[0])*60+Integer.parseInt(arr[1]);
    }

    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {

        int len = stringToTime(video_len);
        int p = stringToTime(pos);
        int os = stringToTime(op_start);
        int oe = stringToTime(op_end);

        if(os <= p && p <= oe) {
            p = oe;
        }

        for(String com : commands) {
            if(com.equals("next")) {
                p += 10;

                if(p > len) p = len;

            } else if(com.equals("prev")) {
                p -= 10;

                if(p < 0) p = 0;
            }

            if(os <= p && p <= oe) {
                p = oe;
            }
        }

        int hh = p/60;
        int mm = p - hh*60;

        return (hh<10 ? "0"+hh:""+hh)+":"+(mm<10 ? "0"+mm:""+mm);
    }
//    }

    public static void main(String[] args) {
        Pg340213 p = new Pg340213();
        System.out.println(p.solution("10:55", "00:05", "00:15", "06:55", new String[]{"prev", "next", "next"}));
    }
}
