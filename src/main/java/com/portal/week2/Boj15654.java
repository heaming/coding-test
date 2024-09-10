package com.portal.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @date 2024-08-17
 * @title N과 M 5
 * @tag dfs 수열
 * @link https://www.acmicpc.net/problem/15654
 */
public class Boj15654 {

//    public class Main {

    static int N;
    static int M;
    static int[] nums;
    static List<ArrayList<Integer>> combis = new ArrayList<>();
    static StringBuilder sb = new StringBuilder();

    static void dfs(boolean[] visited, ArrayList<Integer> combi) {

        if(combi.size() >= M) {
            ArrayList<Integer> temp = new ArrayList<>(combi);
            combis.add(temp);

            for(int i : temp) {
                sb.append(i).append(" ");
            }
            System.out.println(sb);
            sb = new StringBuilder();
            return;
        } else {
            for(int i=0; i<N; i++) {
                if (!visited[i]) {
                    visited[i] = true;
                    combi.add(nums[i]);
                    dfs(visited, combi);
                    combi.remove(combi.indexOf(nums[i]));
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
        st = new StringTokenizer(br.readLine());
        for(int i=0; i<N; i++) {
            nums[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(nums);

        dfs(new boolean[N], new ArrayList<>());
    }
//    }
}
