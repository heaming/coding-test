package com.portal.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;

/**
 * @tag : 완전탐색
 * @link : https://www.acmicpc.net/problem/2798
 */
public class Boj2798 {

//    public class Main {

        static int N;
        static int M;
        static Integer[] cards;

        static int answer = -1;

        static void dfs(boolean[] visited, int cnt, int sum) {
            if(sum > M) {
                return;
            }

            if(cnt >= 3) {
                answer = Math.max(sum, answer);
                return;
            }

            for(int i=0; i<N; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    dfs(visited, cnt+1, sum+cards[i]);
                    visited[i] = false;
                }
            }

        }

        public static void main(String[] args) throws IOException {

            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            cards = new Integer[N];

            for(int i=0; i<N; i++) {
                cards[i] = Integer.parseInt(st.nextToken());
            }

            dfs(new boolean[N], 0,0);

            System.out.println(answer);

        }

//    }


}
