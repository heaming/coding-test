package com.portal.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @date 2024-08-17
 * @title N과 M 6
 * @tag dfs 조합 - 중복 없는
 * @link https://www.acmicpc.net/problem/15655
 */
public class Boj15655 {

//    public class Main {

    static int N;
    static int M;
    static int[] nums;
    static StringBuilder sb;
    static int[] res;
    static boolean[] visited;

    static void dfs(int idx, int cur) {

        if(idx >= M) {
            sb = new StringBuilder();
            for(int i : res) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            return;
        }

        for(int i=cur; i<N; i++) {
            if(visited[i]) continue;
            visited[i] = true;
            res[idx] = nums[i];
            dfs(idx+1, i);
            visited[i] = false;
        }
    }


    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        nums = new int[N];
        visited = new boolean[N];
        res = new int[M];
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(nums);
        dfs(0, 0);


    }
//    }
}
