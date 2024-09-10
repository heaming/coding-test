package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @title 텀 프로젝트
 * @since 2024-08-23
 * @url https://www.acmicpc.net/problem/9466
 * @tag 텀 프로젝트
 */
public class Boj9466 {
//    public class Main {

    static int T;
    static int n;
    static int[] students;
    static int answer;
    static boolean[] visited, team;

    static void dfs(int cur) {

        if(team[cur]) return;

        if(visited[cur]) {
            team[cur] = true;
            answer++;
        }

        visited[cur] = true;
        dfs(students[cur]);
        team[cur] = true;
        visited[cur] = false;
    }



    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        T = Integer.parseInt(st.nextToken());
        for(int t=0; t<T; t++) {
            st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken());
            students = new int[n+1];
            team = new boolean[n+1];
            answer = 0;
            visited = new boolean[n+1];
            st = new StringTokenizer(br.readLine());
            for(int i=1; i<=n; i++) {
                students[i] = Integer.parseInt(st.nextToken());
            }

            for(int i=1; i<=n; i++) {
                 dfs(i);
            }
            System.out.println(n-answer);
        }

    }

}
