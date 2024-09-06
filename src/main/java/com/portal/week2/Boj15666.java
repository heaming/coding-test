package com.portal.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date 2024-08-17
 * @title N과 M 12
 * @tag dfs 조합
 * @link https://www.acmicpc.net/problem/15666
 */
public class Boj15666 {

//    public class Main {

    static int N;
    static int M;
    static int[] nums;
    static StringBuilder sb;
    static int[] res;

    static void dfs(int resIdx, int cur) {

        if(resIdx >= M) {
            sb = new StringBuilder();
            for(int i : res) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        int prev = -1;
        for(int i=cur; i<N; i++) {
            if(prev == nums[i]) continue;

            prev = nums[i];
            res[resIdx] = nums[i];
            dfs(resIdx+1, i);
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
        dfs(0,0);

    }
//    }
}
