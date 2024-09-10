package com.portal.week3;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * @title 석유시추
 * @since 2024-08-20
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/250136
 * @tag
 */
public class Pg250136 {
    static int n;
    static int m;
    static boolean[][] visited;
    static int[] dr = {1,-1,0,0};
    static int[] dc = {0,0,1,-1};
    static int[][] land;
    static int[] oils;

    static class Info {
        int sum;
        Set<Integer> cols;

        public Info(int sum, Set<Integer> cols) {
            this.sum = sum;
            this.cols = cols;
        }

        @Override
        public String toString() {
            return "Info{" +
                    "sum=" + sum +
                    ", cols=" + cols +
                    '}';
        }
    }

    static Info dfs(int r, int c, Info info) {
        info.sum = 1;

        visited[r][c] = true;
        info.cols.add(c);

        for(int i=0; i<4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(nr<0 || nc<0 || nr>=n || nc>= m) continue;
            if(visited[nr][nc] || land[nr][nc] == 0) continue;
            info.sum += dfs(nr, nc, info).sum;
        }

        return info;
    }

    public int solution(int[][] land) {
        int answer = 0;
        this.land = land;
        n = land.length;
        m = land[0].length;
        visited = new boolean[n][m];
        oils = new int[m];

        for(int i=0; i<n; i++) {
            for(int j=0; j<m; j++) {
                // 칸마다 계산
                if(visited[i][j]) continue;
                if(land[i][j] == 0) continue;
                Info info = dfs(i, j, new Info(0, new HashSet<>()));

                Iterator<Integer> it = info.cols.iterator();
                while(it.hasNext()) {
                    oils[it.next()] += info.sum;
                }
            }
        }

        for(int i : oils) {
            answer = Math.max(i, answer);
        }

        return answer;
    }

    public static void main(String[] args) {
        Pg250136 pg = new Pg250136();
        System.out.println(pg.solution(new int[][]{{0, 0, 0, 1, 1, 1, 0, 0}, {0, 0, 0, 0, 1, 1, 0, 0}, {1, 1, 0, 0, 0, 1, 1, 0}, {1, 1, 1, 0, 0, 0, 0, 0}, {1, 1, 1, 0, 0, 0, 1, 1}}));
    }
}
