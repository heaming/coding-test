package com.portal.week3;

import java.util.Arrays;

/**
 * @title 산 모양 타일링
 * @since 2024-08-20
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/258705
 * @tag dp
 */
public class Pg258705 {

    static int[][] dy; // 0 다이아몬드 끝에 없는 경우 1 다이아몬드 끝에 있는 경우
    static int MOD = 10007;

    public int solution(int n, int[] tops) {
        dy = new int[n+1][2];

        dy[0][0] = 1;

        for(int i=1; i<=n; i++) {
            dy[i][1] = (dy[i-1][0]+dy[i-1][1]) %MOD;

            if(tops[i-1] == 0) {
                dy[i][0] = (dy[i-1][0]+dy[i-1][0]+dy[i-1][1]) %MOD;
            } else {
                dy[i][0] = (dy[i-1][0]+dy[i-1][0]+dy[i-1][0]+dy[i-1][1]+dy[i-1][1]) %MOD;
            }
        }

        return (dy[n][0]+dy[n][1])%MOD;
    }

    public static void main(String[] args) {
        Pg258705 pg = new Pg258705();
        System.out.println(pg.solution(4, new int[]{1,1,0,1}));
        System.out.println(pg.solution(2, new int[]{0,1}));
    }
}
