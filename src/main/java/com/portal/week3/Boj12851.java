package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 * @title 숨바꼭질2
 * @since 2024-08-20
 * @url https://www.acmicpc.net/problem/12851
 * @tag bfs
 */
public class Boj12851 {
//    public class Main {
    static int N;
    static int K;

    static class State {
        int idx;
        int time;

        public State(int idx, int time) {
            this.idx = idx;
            this.time = time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        int answer = 0;
        int min = Integer.MAX_VALUE;
        int[] times = new int[100001];
        Arrays.fill(times, Integer.MAX_VALUE);

        Queue<State> que = new LinkedList<>();
        que.offer(new State(N,0));
        times[N] = 0;

        while(!que.isEmpty()) {
            State cur = que.poll();

            if(cur.idx < 0 || cur.idx > 100000) continue;
            if(cur.time > min) continue;
            if(times[cur.idx] < cur.time) continue;

            times[cur.idx] = cur.time;

            if(cur.idx == K) {
                if(cur.time < min) {
                    answer = 1;
                    min = cur.time;
                } else if(cur.time == min) {
                    answer++;
                }
                continue;
            }

            que.offer(new State(cur.idx-1, cur.time+1));
            que.offer(new State(cur.idx+1, cur.time+1));
            que.offer(new State(cur.idx*2, cur.time+1));
        }

        System.out.println(min);
        System.out.println(answer);

        br.close();
    }



//    }
}
