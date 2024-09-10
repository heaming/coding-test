package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title 토마토
 * @since 2024-08-21
 * @url https://www.acmicpc.net/problem/7576
 * @tag bfs
 */
public class Boj7576 {
//    public class Main {

    static int M; // 가로
    static int N; // 세로
    static int[][] tomato;
    static int[][] days;
    static int[] dn = {1,-1,0,0};
    static int[] dm = {0,0,-1,1};

    static class Node {
        int n;
        int m;
        int d;

        public Node(int n, int m, int d) {
            this.n = n;
            this.m = m;
            this.d = d;
        }
    }

    static int check() {
        int max = Integer.MIN_VALUE;
        for(int i=0; i<N; i++) {
            for(int j=0; j<M; j++) {
                if(tomato[i][j] == 0) return -1;
                max = Math.max(days[i][j], max);
            }
        }
        return max;
    }

    public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        tomato = new int[N][M];
        days = new int[N][M];
        Queue<Node> que = new LinkedList<>();
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<M; j++) {
                int state = Integer.parseInt(st.nextToken());
                tomato[i][j] = state;
                days[i][j] = 0;
                if(state == 1) {
                    que.offer(new Node(i, j, 0));
                }
            }
        }

        while(!que.isEmpty()) {
            Node cur = que.poll();

            for(int i=0; i<4; i++) {
                int nn = cur.n+dn[i];
                int nm = cur.m+dm[i];

                if(0<=nn && nn<N && 0<=nm && nm<M && tomato[nn][nm] == 0) {
                    days[nn][nm] = cur.d+1;
                    tomato[nn][nm] = 1;
                    que.offer(new Node(nn, nm, cur.d+1));
                }
            }
        }

        System.out.println(check());


    }
//    }
}
