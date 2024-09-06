package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @title 아기 상어
 * @since 2024-08-23
 * @url https://www.acmicpc.net/problem/16236
 * @tag bfs 이중 우선순위큐
 */
public class Boj16236 {
    // public class Main {

    static int N;
    static int[][] map;
    static boolean[][] visited;
    static int[] dr = {1,0,-1,0};
    static int[] dc = {0,-1,0,1};
    static Node cur;

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
        N = Integer.parseInt(st.nextToken());
        map = new int[N][N];

        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if(map[i][j] == 9) {
                    cur = new Node(i, j, 0);
                    map[i][j] = 0;
                }
            }
        }

        int size = 2;
        int eat = 0;
        int time = 0;

        while(true) {
            PriorityQueue<Node> shark = new PriorityQueue<>((o1, o2) ->
                    (o1.t == o2.t) ? (o1.r == o2.r ? Integer.compare(o1.c, o2.c) : Integer.compare(o1.r, o2.r)) : Integer.compare(o1.t, o2.t)
            );
            visited = new boolean[N][N];
            shark.offer(new Node(cur.r, cur.c, 0));
            visited[cur.r][cur.c] = true;
            boolean flag = false;

            while(!shark.isEmpty()) {
                cur = shark.poll();

                // 상어가 먹을 수 있는 물고기 -> 먹는다
                if(0 < map[cur.r][cur.c] && map[cur.r][cur.c] < size) {
                    map[cur.r][cur.c] = 0;
                    eat++;
                    time += cur.t;
                    flag = true;
                    break;
                }

                for(int i=0; i<4; i++) {
                    int nr = cur.r+dr[i];
                    int nc = cur.c+dc[i];

                    if(nr<0 || nr>=N || nc<0 || nc>=N) continue;
                    if(visited[nr][nc] || map[nr][nc] > size) continue;

                    shark.offer(new Node(nr, nc, cur.t+1));
                    visited[nr][nc] = true;
                }
            }

            if(!flag) break;

            if(size == eat) {
                eat = 0;
                size++;
            }
        }

        System.out.println(time);

    }
}
