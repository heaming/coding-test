package com.portal.week5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 가장 긴 바이토닉 부분 수열
 * @url https://www.acmicpc.net/problem/11054
 * @tag
 * @since 2024-09-10
 */
public class Boj11054 {

    static int N;
    static int[] arr;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] up = new int[N+1];
        for(int i=1; i<=N; i++) {
            up[i] = 1;

            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j]) {
                    up[i] = Math.max(up[j]+1, up[i]);
                }
            }
        }

        int[] down = new int[N+1];
        for(int i=N; i>0; i--) {
            down[i] = 1;

            for(int j=N; j>i; j--) {
                if(arr[i] > arr[j]) {
                    down[i] = Math.max(down[j]+1, down[i]);
                }
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, up[i]+down[i]);
        }

        System.out.println(max-1);
    }
}
