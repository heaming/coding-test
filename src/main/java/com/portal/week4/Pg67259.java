package com.portal.week4;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title 경주로 건설
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/67259
 * @tag bfs, dp
 * @since 2024-09-08
 */
public class Pg67259 {
//    class Solution {

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
    public int solution(int[][] board) {
        int answer = Integer.MAX_VALUE;
        int len = board.length;

        int[][][] dist = new int[len][len][4];
        boolean[][][] visited = new boolean[len][len][4];

        Queue<Node> que = new LinkedList<>();
        que.offer(new Node(0,0, -1, 0));

        while(!que.isEmpty()) {

            Node cur = que.poll();

            if(cur.n == len-1 && cur.m == len-1) {
                answer = Math.min(answer, cur.c);
            }

            for(int i=0; i<4; i++) {
                int nn = cur.n+dn[i];
                int nm = cur.m+dm[i];

                if(nn<0 || nn>=len || nm<0 || nm>=len || board[nn][nm] != 0) continue;

                int nc = cur.c;
                if(i == cur.d || cur.d == -1) {
                    nc += 100;
                } else {
                    nc += 600;
                }

                if(!visited[nn][nm][i] || nc < dist[nn][nm][i]) {
                    visited[nn][nm][i] = true;
                    dist[nn][nm][i] = nc;
                    que.offer(new Node(nn, nm, i, nc));
                }
            }
        }

        return answer;
    }

    public static void main(String[] args) {
            Pg67259 p = new Pg67259();
        System.out.println(p.solution(new int[][]{{0, 0, 1,0}, {0, 0, 0,0}, {0, 1, 0,1},{1,0,0,0}}));
    }
}
