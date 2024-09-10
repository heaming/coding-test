package com.portal.week3;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @title 공 이동 시뮬레이션
 * @since 2024-08-20
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/87391
 * @tag 구현
 */

public class Pg87391 {
    public long solution(int n, int m, int x, int y, int[][] queries) {
        // 가능한 열, 행의 범위 정하기
        long left = y;
        long right = y;
        long top = x;
        long botton = x;

        for(int i = queries.length-1; i>=0; i--) {
            int[] query = queries[i];

            if (query[0] == 0) {
                if(left != 0) {
                    left += query[1];
                }
                right = Math.min(m-1, right+query[1]);
            } else if (query[0] == 1) {
                if(right != m-1) {
                    right -= query[1];
                }
                left = Math.max(0, left-query[1]);
            } else if (query[0] == 2) {
                if(top != 0) {
                    top += query[1];
                }
                botton = Math.min(n-1, botton+query[1]);
            } else if (query[0] == 3) {
                if(botton != n-1) {
                    botton -= query[1];
                }
                top = Math.max(0, top-query[1]);
            }
            if(left >= m || right < 0 || top >= n || botton < 0) return 0;
        }

        System.out.println(top + " " + botton + " " + left + " " + right);

        return (right-left+1) * (botton-top+1);
    }

    public static void main(String[] args) {
        Pg87391 pg = new Pg87391();
        System.out.println(pg.solution(2,5,0,0,new int[][]{{3,1},{2,2},{1,1},{2,3},{0,1},{2,1}}));
    }
}
