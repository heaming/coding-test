package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @title 트리와 쿼리
 * @since 2024-08-20
 * @url https://www.acmicpc.net/problem/15681
 * @tag dfs 그래프
 */
public class Boj15681 {
//    public class Main {

    static int N;
    static int R;
    static int Q;
    static List<Integer>[] graph;
    static int[] kids;
    static boolean[] visited;

    static int dfs(int cur, int prev) {
        visited[cur] = true;

        kids[cur] = 1;
        for(int next : graph[cur]) {
            if(visited[next]) continue;
            kids[cur] += dfs(next, cur);
        }

        return kids[cur];
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        R = Integer.parseInt(st.nextToken());
        Q = Integer.parseInt(st.nextToken());
        graph = new List[N+1];
        kids = new int[N+1];
        visited = new boolean[N+1];

        for(int i=1; i<=N; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=1; i<=N-1; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph[a].add(b);
            graph[b].add(a);
        }

        dfs(R, 0);

        for(int i=1; i<=Q; i++) {
            st = new StringTokenizer(br.readLine());
            int q = Integer.parseInt(st.nextToken());
            System.out.println(kids[q]);
        }

    }

//    }

}
