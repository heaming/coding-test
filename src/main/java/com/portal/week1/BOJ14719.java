package com.portal.week1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title boj14719
 * @author hey._.mi
 * @link https://www.acmicpc.net/problem/14719
 * @since 2024.08.09
 * @tag 구현
 */
public class BOJ14719 {
    static int H;
    static int W;
    static int[] block;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        H = Integer.parseInt(st.nextToken());
        W = Integer.parseInt(st.nextToken());
        block = new int[W];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<W; i++) {
            block[i] = Integer.parseInt(st.nextToken());
        }

        int answer = 0;

        for(int i=1; i<W-1; i++) {
            int left = 0;
            int right = 0;

            for(int l=0; l<i; l++) {
                left = Math.max(left, block[l]);
            }

            for(int r=i+1; r<W; r++) {
                right = Math.max(right, block[r]);
            }

            if(block[i] < left && block[i] < right) {
                answer += Math.min(left, right) - block[i];
            }
        }

        System.out.println(answer);

        br.close();

    }
}
