package com.portal.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title boj14719
 * @author hey._.mi
 * @link https://www.acmicpc.net/problem/10844
 * @since 2024.08.09
 * @tag bp
 */
public class BOJ10844 {
    static int N;
    static int[][] dy;
    static int MOD =  1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        dy = new int[N+1][10];

        /*
        i = 2
        0 10
        1 21
        2 12 32
        3 23 43
        4 54 34

        i = 3
        0 210
        1 101 121 321
        2 212 432 232
        3 123 323 343 543

        i = 4
        0 1210 3210 1010

         */
        for(int i=1; i<=9; i++) {
            dy[1][i] = 1;
        }

        for(int i=2; i<=N; i++) {
            for(int j=0; j<=9; j++) {
                if(j==0) {
                    dy[i][j] = dy[i-1][1]%MOD;
                    continue;
                }
                if(j==9) {
                    dy[i][j] = dy[i-1][8]%MOD;
                    continue;
                }

                dy[i][j] = (dy[i-1][j+1]+dy[i-1][j-1])%MOD;
            }
        }

        int answer = 0;
        for(int i=0; i<=9; i++) {
            answer += dy[N][i];
            answer %= MOD;
        }

        System.out.println(answer);
    }
}
