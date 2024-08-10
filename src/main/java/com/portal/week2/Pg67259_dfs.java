package com.portal.week2;

import static com.portal.week2.Pg67259_dfs.Solution.solution;

public class Pg67259_dfs {
    class Solution {

        static int[] dn = {0,0,1,-1};
        static int[] dm = {1,-1,0,0};
        static Node end;

        static class Node {
            int n;
            int m;

            public Node(int n, int m) {
                this.n = n;
                this.m = m;
            }
        }

        static int answer = Integer.MAX_VALUE;

        static void dfs(int[][] board, boolean[][] visited, Node cur, Node prev, int cost) {

            if(cur.n == end.n && cur.m == end.m) {
                answer = Math.min(answer, cost);

                return;
            }

            for(int i=0; i<4; i++) {
                int nn = cur.n+dn[i];
                int nm = cur.m+dm[i];

                if(nn>=0 && nn<=end.n && nm>=0 && nm<=end.m && board[nn][nm] == 0 && !visited[nn][nm]) {
                    visited[nn][nm] = true;
                    if(prev.n == nn || prev.m == nm) { // 직선도로
                        dfs(board, visited, new Node(nn,nm), cur, cost+100);
                    } else { // 코너
                        dfs(board, visited, new Node(nn,nm), cur, cost+600);
                    }
                    visited[nn][nm] = false;
                }

            }

        }

        public static int solution(int[][] board) {

            end = new Node(board.length-1, board.length-1);
            dfs(board, new boolean[board.length][board.length], new Node(0,0), new Node(0,0), 0);


            return answer;
        }

    }
        public static void main(String[] args) {
            System.out.println(solution(new int[][]{{0,0,0},{0,0,0},{0,0,0}}));
        }
}
