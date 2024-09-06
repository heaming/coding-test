package com.portal.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @date 2024-08-17
 * @title N과 M 9
 * @tag dfs 수열 - 중복 없는
 * @link https://www.acmicpc.net/problem/15663
 */
public class Boj15663 {

//    public class Main {

    static int N;
    static int M;
    static int[] nums;
    static StringBuilder sb;
    static int[] res;

    static void dfs(boolean[] visited, int idx) {
        if(idx >= M) {
            sb = new StringBuilder();
            for(int i : res) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        } else {
            int before = 0;

            for(int i=0; i<N; i++) {
                if(visited[i]) continue;

                if(before != nums[i]) {
                    before = nums[i];
                    visited[i] = true;
                    res[idx] = nums[i];
                    dfs(visited, idx+1);
                    visited[i] = false;
                }

            }

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

        dfs(new boolean[N], 0);


    }
//    }
}
