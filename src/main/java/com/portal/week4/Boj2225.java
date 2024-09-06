package com.portal.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 합분해
 * @url https://www.acmicpc.net/problem/2225
 * @tag
 * @since 2024-09-06
 */
public class Boj2225 {
    static int N;
    static int K;
    static int[][] dy;
    static int MOD = 1_000_000_000;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());
        dy = new int[K+1][N+1];

        for(int i=0; i<=N; i++) {
            dy[1][i] = 1;
        }
        for(int i=1; i<=K; i++) {
            dy[i][0] = 1;
        }

        for(int i=2; i<=K; i++) {
            for(int j=1; j<=N; j++) {
                dy[i][j] = dy[i-1][j] + dy[i][j-1];
                dy[i][j] %= MOD;
            }
        }

        System.out.println(dy[K][N]);
    }
}
