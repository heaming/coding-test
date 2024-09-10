package com.portal.week4;

import java.util.*;

/**
 * @title PCCP 3 - 충돌위험 찾기
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/340211
 * @tag
 * @since 2024-09-08
 */

public class Pg340211 {

    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};

    static class Node {
        int r;
        int c;

        public Node(int r, int c) {
            this.r = r;
            this.c = c;
        }
    }

    public int solution(int[][] points, int[][] routes) {
        int answer = 0;
        int[][][] dist = new int[10][10][routes.length];

        for(int i=0; i<routes.length; i++) {
            int[] curRoute = routes[i];

            for(int j=0; j<curRoute.length; j++) {
                Queue<Node> que = new LinkedList<>();
                boolean[][] visited = new boolean[10][10];
                int p = curRoute[j];
                que.offer(new Node(points[p-1][0], points[p-1][1]));
                visited[points[p-1][0]][points[p-1][1]] = true;

                while(!que.isEmpty()) {
                    Node cur = que.poll();

                    for(int d=0; d<4; d++) {
                        int nr = cur.r+dr[i];
                        int nc = cur.c+dc[i];

                        if(nr<=0 || nr>=10 || nc<=0 || nc>=10) continue;
                        if(!visited[nr][nc] || (visited[nr][nc]&&dist[nr][nc][i] > cur.c+1)) {
                            dist[nr][nc][i] = cur.c+1;
                            visited[nr][nc] = true;
                            que.offer(new Node(nr, nc));
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(dist));

        return answer;
    }

    public static void main(String[] args) {
        Pg340211 p = new Pg340211();
        System.out.println(p.solution(new int[][]{{3, 2}, {6, 4}, {4, 7}, {1, 4}}, new int[][]{{4, 2}, {1, 3}, {2, 4}}));
    }
}
