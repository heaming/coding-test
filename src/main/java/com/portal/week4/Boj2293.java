package com.portal.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 동전1
 * @url https://www.acmicpc.net/problem/2293
 * @tag dp
 * @since 2024-09-06
 */
public class Boj2293 {

    static int n;
    static int k;
    static int[] coins;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        coins = new int[n+1];
        dy = new int[10001];
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            coins[i] = Integer.parseInt(st.nextToken());
        }

        dy[0] = 1;
        for(int i=1; i<=n; i++){
            for(int j=coins[i]; j<=k; j++) {
                dy[j] += dy[j-coins[i]];
            }
        }

        System.out.println(dy[k]);
        br.close();

    }

}
