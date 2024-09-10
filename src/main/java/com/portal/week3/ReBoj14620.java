package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * <pre>RE-Test</pre>
 * 2024-08-23
 * https://www.acmicpc.net/problem/14620
 */
public class ReBoj14620 {

//    public class Main {

    static int N;
    static int[][] map;
    static int[] dr = {0,1,-1,0,0};
    static int[] dc = {0,0,0,1,-1};
    static int answer = Integer.MAX_VALUE;
    static boolean[][] visited;

    static void dfs(int flower, int cost, boolean[][] visited) {
        if(cost >= answer) return;

        if(flower >= 3) {
            answer = Math.min(answer, cost);
            return;
        }

        for(int i=0; i<N; i++) {
            for(int j=0; j<N; j++) {

                boolean flag = true;

                for(int d=0; d<5; d++) {
                    int nr = i+dr[d];
                    int nc = j+dc[d];

                    if(nr<0 || nr>=N || nc<0 || nc>=N || visited[nr][nc]) {
                        flag = false;
                        break;
                    }
                }

                if(!flag) continue;

                int sum = 0;

                for(int d=0; d<5; d++) {
                    int nr = i+dr[d];
                    int nc = j+dc[d];

                    visited[nr][nc] = true;
                    sum += map[nr][nc];
                }
                dfs(flower+1, cost+sum, visited);
                for(int d=0; d<5; d++) {
                    int nr = i+dr[d];
                    int nc = j+dc[d];

                    visited[nr][nc] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];
        visited = new boolean[N][N];
        for(int i=0; i<N; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        dfs(0, 0, visited);


        System.out.println(answer);
    }
}
