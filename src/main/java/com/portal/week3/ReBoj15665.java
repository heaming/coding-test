package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2024-08-23
 * https://www.acmicpc.net/problem/15665
 */
public class ReBoj15665 {
    // public class Main {

    static int N;
    static int M;
    static int[] nums;
    static int[] res;
    static StringBuilder sb;

    static void dfs(int resIdx) {
        if(resIdx >= M) {
            sb = new StringBuilder();
            for(int i=0; i<M; i++) {
                sb.append(res[i]).append(" ");
            }
            System.out.println(sb);
            return;
        }

        int prev = 0;
        for(int i=0; i<N; i++) {
            if(prev == nums[i]) continue;
            res[resIdx] = nums[i];
            prev = nums[i];
            dfs(resIdx+1);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        res = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dfs(0);

    }

}
