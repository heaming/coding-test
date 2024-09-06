package com.portal.week3;

/**
 * @title 순위
 * @tag 그래프 다익스트라
 * @since 2024-08-19
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/49191
 */
public class Pg49191 {
    static int[][] winner;

    public int solution(int n, int[][] results) {
        int answer = 0;
        winner = new int[n+1][n+1];

        for(int[] res : results) {
            winner[res[0]][res[1]] = 1;
            winner[res[1]][res[0]] = -1;
        }

        for(int i=1; i<=n; i++) { // 기준 선수
            for(int j=1; j<=n; j++) {
                for(int k=1; k<=n; k++) {
                    if(i == k) continue;

                    // i가 j 이김 j가 k 이김 -> i가 k이김
                    if(winner[i][j] == 1 && winner[j][k] == 1) {
                        winner[i][k] = 1;
                        winner[k][i] = -1;
                    }
                    if(winner[i][j] == -1 && winner[j][k] == -1) {
                        winner[i][k] = -1;
                        winner[k][i] = 1;
                    }
                }
            }
        }

        for(int i=1; i<=n; i++) {
            boolean flag = true;
            for(int j=1; j<=n; j++) {
                if(i==j) continue;
                if(winner[i][j] == 0) {
                    flag = false;
                    break;
                }
            }
            if(flag) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Pg49191 pg = new Pg49191();
        System.out.println(pg.solution(5, new int[][]{{4, 3}, {4, 2}, {3, 2}, {1, 2}, {2, 5}}));
    }
}
