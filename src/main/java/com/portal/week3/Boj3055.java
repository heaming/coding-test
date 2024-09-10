package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title 탈출
 * @since 2024-08-23
 * @url https://www.acmicpc.net/problem/3055
 * @tag bfs
 */
public class Boj3055 {
//    public class Main {

    static int R;
    static int C;
    static char[][] map;
    static Node start;
    static Node end;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int[][] time;

    static class Node {
        int r;
        int c;
        int t;

        public Node(int r, int c, int t) {
            this.r = r;
            this.c = c;
            this.t = t;
        }
    }


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        R = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());
        map = new char[R][C];
        time = new int[R][C];
        Queue<Node> que = new LinkedList<>();
        Queue<Node> water = new LinkedList<>();
        for(int i=0; i<R; i++) {
            st = new StringTokenizer(br.readLine());
            String s = st.nextToken();
            for(int j=0; j<C; j++) {
                map[i][j] = s.charAt(j);
                if(s.charAt(j) == 'D') {
                    end = new Node(i, j,0);
                }
                if(s.charAt(j) == 'S') {
                    start = new Node(i, j,0);
                    que.offer(start);
                }
                if(s.charAt(j) == '*') {
                    water.offer(new Node(i,j,0));
                }
            }
        }
        // 물 채우기
        // 고슴도치 이동


        boolean[][] visited = new boolean[R][C];
        while(!water.isEmpty()) {
            Node cur = water.poll();

            for(int i=0; i<4; i++) {
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];

                if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == '.') {
                    visited[nr][nc] = true;
                    time[nr][nc] += time[cur.r][cur.c]+1;
                    water.offer(new Node(nr,nc,0));
                }
            }
        }

        for(int[] a : time) {
            System.out.println(Arrays.toString(a));
        }

        int answer = Integer.MAX_VALUE;
        visited = new boolean[R][C];

        while (!que.isEmpty()) {
            Node cur = que.poll();
            if(cur.r == end.r && cur.c == end.c) {
                answer = Math.min(answer, cur.t);
            }

            for(int i=0; i<4; i++) {
                int nr = cur.r+dr[i];
                int nc = cur.c+dc[i];

                if(nr<0 || nr>=R || nc<0 || nc>=C) continue;
                if(visited[nr][nc]) continue;
                if(map[nr][nc] == 'X') continue;
                visited[nr][nc] = true;
                if(nr == end.r && nc == end.c) {
                    answer = Math.min(answer, cur.t+1);
                    break;
                } else if(cur.t+1 < time[nr][nc] || time[nr][nc] == 0) {
                    que.offer(new Node(nr, nc, cur.t+1));
                }
            }
        }

        System.out.println(answer == Integer.MAX_VALUE ? "KAKTUS" : answer);


    }
}
