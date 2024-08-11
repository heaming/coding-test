package com.portal.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @tag : 완전탐색
 * @link : https://www.acmicpc.net/problem/14620
 */
public class Boj14620 {


//    public class Main {


        static int N;
        static int[][] board;
        static int[] dn = {0,1,-1,0,0};
        static int[] dm = {0,0,0,1,-1};

        static int answer = Integer.MAX_VALUE;

        static void dfs(int flowers, int cost, boolean[][] visited) {
            if(cost >= answer) return;

            if(flowers >= 3) {
                answer = Math.min(answer,cost);
                return;
            }

            for(int n = 1; n<N-1; n++) {
                for(int m = 1; m <N-1; m++) {
                    if(visited[n][m]) continue;
                    boolean flag = true;

                    for(int d=1; d<5; d++) {
                        int nn= n+dn[d];
                        int nm= m+dm[d];

                        if (visited[nn][nm]) {
                            flag = false;
                            break;
                        }
                    }

                    if(!flag) continue;

                    int sum = 0;

                    for(int d=0; d<5; d++) {
                        int nn= n+dn[d];
                        int nm= m+dm[d];

                        sum += board[nn][nm];
                        visited[nn][nm] = true;
                    }

                    dfs(flowers+1, cost+sum, visited);

                    for(int d=0; d<5; d++) {
                        int nn= n+dn[d];
                        int nm= m+dm[d];

                        visited[nn][nm] = false;
                    }
                }
            }

        }

        public static void main(String[] args) throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            StringTokenizer st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            board = new int[N][N];
            for(int i=0; i<N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j=0; j<N; j++) {
                    board[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            dfs(0,0, new boolean[N][N]);

            System.out.println(answer);

        }
//    }
}
