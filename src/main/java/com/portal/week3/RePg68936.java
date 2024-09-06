package com.portal.week3;

import java.util.Arrays;

/**
 * 2024-08-23
 * https://school.programmers.co.kr/learn/courses/30/lessons/68936
 */
public class RePg68936 {

    static int[][] arr;
    static int[] answer = new int[2];

    static boolean check(int r, int c, int mid) {
        int start = arr[r][c];

        for(int i=0; i<mid; i++){
            for(int j=0; j<mid; j++) {
                if(start != arr[r+i][c+j]) return false;
            }
        }

        return true;
    }

    static void dfs(int r, int c, int mid) {

        if(check(r, c, mid)) {
            answer[arr[r][c]]++;
            return;
        }

        int m = mid/2;

        dfs(r, c, m);
        dfs(r+m, c, m);
        dfs(r, c+m, m);
        dfs(r+m, c+m, m);
    }

    public int[] solution(int[][] arr) {
        this.arr = arr;

        dfs(0,0,arr.length);
        return answer;
    }

    public static void main(String[] args) {
        RePg68936 pg = new RePg68936();


        System.out.println(Arrays.toString(pg.solution(new int[][]{{1, 1, 0, 0}, {1, 0, 0, 0}, {1, 0, 0, 1}, {1, 1, 1, 1}})));
    }



}
