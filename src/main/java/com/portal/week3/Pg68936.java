package com.portal.week3;

import java.util.Arrays;

/**
 * @title 쿼드압축 후 개수 세기
 * @since 2024-08-20
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/68936
 * @tag
 */
public class Pg68936 {
    static int[] answer;
    static int[][] arr;

    static boolean valid(int r, int c, int m) {
        for(int i=0; i<m; i++) {
            for(int j=0; j<m; j++) {
                if(arr[r][c] != arr[r+i][c+j]) return false;
            }
        }

        return true;
    }

    static void dfs(int r, int c, int m) {

        if(valid(r, c, m)) {
            int temp = arr[r][c];
            answer[temp]++;
            return;
        }

        // 4영역으로 나누기
        int mid = m/2;

        dfs(r, c, mid);
        dfs(r+mid, c, mid);
        dfs(r, c+mid, mid);
        dfs(r+mid, c+mid, mid);

    }

    public int[] solution(int[][] arr) {
        answer = new int[2];
        this.arr = arr;

        dfs(0, 0, arr.length);

        return answer;
    }

    public static void main(String[] args) {
        Pg68936 pg = new Pg68936();
        System.out.println(Arrays.toString(pg.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }

}
