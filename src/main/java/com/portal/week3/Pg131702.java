package com.portal.week3;

import java.util.Arrays;

/**
 * @title 고고학 최고의 발견
 * @since 2024-08-20
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/131702
 * @tag 구현
 */
public class Pg131702 {

    static int answer = Integer.MAX_VALUE;
    static int len;
    static int[] dc = {1, -1, 0, 0};
    static int[] dr = {0,0,1,-1};

    static int[][] deepCopy(int[][] arr) {
        int[][] temp = new int[len][len];

        for(int i=0; i<len; i++) {
            temp[i] = arr[i].clone();
        }
        return temp;
    }

    static void rotate(int[][] arr, int r, int c, int cnt) {
        arr[r][c] = (arr[r][c]+cnt)%4;

        for(int i=0; i<4; i++) {
            int nr = r+dr[i];
            int nc = c+dc[i];

            if(nr>=0 && nr<len && nc>=0 && nc<len) {
                arr[nr][nc] = (arr[nr][nc] + cnt)%4;
            }
        }
    }

    public int solution(int[][] clockHands) { // 0 12시 1 3시 2 6시 3 9시 모두 0
        len = clockHands.length;

        for(int i=0; i<Math.pow(4, len); i++){
            int[][] arr = deepCopy(clockHands);
            int cnt = 0;
            int temp = i;

            for(int c=0; c<len; c++) {
                int makeCnt = temp%4;
                temp /= 4;
                cnt += makeCnt;
                rotate(arr, 0, c, makeCnt);
            }

            for(int r=1; r<len; r++) {
                for(int c=0; c<len; c++) {
                    int makeCnt = (4-arr[r-1][c])%4;
                    cnt += makeCnt;
                    rotate(arr, r, c, makeCnt);
                }
            }

            boolean flag = true;
            for(int c=0; c<len; c++) {
                if(arr[len-1][c] != 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer = Math.min(answer, cnt);
        }

        return answer;
    }
    public static void main(String[] args) {
        Pg131702 pg = new Pg131702();
        System.out.println(pg.solution(new int[][]{{0,3,3,0},{3,2,2,3},{0,3,2,0},{0,3,3,3}}));
    }
}
