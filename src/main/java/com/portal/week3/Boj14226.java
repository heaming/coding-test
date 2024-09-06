package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title 이모티콘
 * @since 2024-08-20
 * @url https://www.acmicpc.net/problem/14226
 * @tag bfs
 */
public class Boj14226 {
//    public class Main{
        static int S;

        static class State {
            int screen;
            int board;
            int time;

            public State(int screen, int board, int time) {
                this.screen = screen;
                this.board = board;
                this.time = time;
            }
        }

        public static void main (String[]args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken());
        boolean[][] check = new boolean[1001][1001];

        Queue<State> que = new LinkedList<>();
        que.offer(new State(1, 0, 0));
        check[1][0] = true;
        int min = Integer.MAX_VALUE;


        while (!que.isEmpty()) {
            State cur = que.poll();

            if (cur.screen == S) {
                min = Math.min(min, cur.time);
                break;
            }


            // 화면 -> 클립보드
            if (cur.screen > 0 && !check[cur.screen][cur.screen]) {
                check[cur.screen][cur.screen] = true;
                que.offer(new State(cur.screen, cur.screen, cur.time + 1));
            }

            if (cur.board > 0 && cur.screen+ cur.board < 1001 && !check[cur.screen+ cur.board][cur.board]) {
                check[cur.screen+ cur.board][cur.board] = true;
                que.offer(new State(cur.screen + cur.board, cur.board, cur.time + 1));
            }

            if (cur.screen-1 > 0 && !check[cur.screen - 1][cur.board]) {
                check[cur.screen - 1][cur.board] = true;
                que.offer(new State(cur.screen - 1, cur.board, cur.time+1));
            }
        }

        System.out.println(min);
    }
//    }
}
