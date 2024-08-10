package com.portal.week2;

import java.util.LinkedList;
import java.util.Queue;

import static com.portal.week2.Pg67259_dfs.Solution.solution;

public class Pg67259_dp {

    class Solution {

        static int[] dn = {0,1,0,-1};
        static int[] dm = {1,0,-1,0};

        static class Node {
            int n;
            int m;
            int d;
            int c;

            public Node(int n, int m, int d, int c) {
                this.n = n;
                this.m = m;
                this.d = d;
                this.c = c;
            }
        }

        static int answer = Integer.MAX_VALUE;

        public int solution(int[][] board) {
            boolean[][][] visited = new boolean[board.length][board.length][4];
            int[][][] costs = new int[board.length][board.length][4];

            Queue<Node> que = new LinkedList<>();
            que.offer(new Node(0,0,-1,0));

            while(!que.isEmpty()) {
                Node cur = que.poll();

                if(cur.n == board.length-1 && cur.m == board.length-1) {
                    answer = Math.min(answer, cur.c);
                }

                for(int i=0; i<4; i++) {
                    int nn = cur.n+dn[i];
                    int nm = cur.m+dm[i];

                    if(nn>=0 && nn<board.length && nm>=0 && nm<board.length && board[nn][nm] == 0) {
                        int nc = cur.c;

                        if(cur.d == i || cur.d == -1) { // 방향이 같거나 시작
                            nc += 100;
                        } else {
                            nc += 600;
                        }

                        if(!visited[nn][nm][i] || nc < costs[nn][nm][i]) {
                            visited[nn][nm][i] = true;
                            costs[nn][nm][i] = nc;
                            que.offer(new Node(nn, nm, i, nc));
                        }


                    }

                }
            }

            return answer;
        }
    }
        public static void main(String[] args) {
            System.out.println(solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        }
}
