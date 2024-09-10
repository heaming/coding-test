package com.portal.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @title 주사위 고르기
 * @since 2024-08-19
 * @tag
 * @url  https://school.programmers.co.kr/learn/courses/30/lessons/258709
 */
public class Pg258709 {
    static int[][] dice;
    static int diceLen;
    static List<Integer> res;
    static List<Integer> pointA;
    static List<Integer> pointB;
    static int maxPercent = Integer.MIN_VALUE;
    static int[] answer;

    static void calPoint(List<Integer> choiceDice, int depth, int sum, List<Integer> points) { // 나올 수 있는 점수
        if(depth >= diceLen/2) {
            points.add(sum);
        } else {
            for(int i=0; i<6; i++) {
                calPoint( choiceDice,depth+1, sum+dice[choiceDice.get(depth)][i], points);
            }
        }
    }

    static int calWinner(List<Integer> diceA, List<Integer> diceB) {
        pointA = new ArrayList<>();
        pointB = new ArrayList<>();

        calPoint(diceA, 0, 0, pointA);
        calPoint(diceB, 0, 0, pointB);

        Collections.sort(pointB);

        System.out.println("pointA :" + pointA);
        System.out.println("pointB :" +pointB);
        // 확률 계산
        int percent = 0;

        for(int a : pointA) {

            int left = 0;
            int right = pointB.size()-1;
            int count = -1;

            while(left <= right) {
                int mid = (left+right)/2;

                if(pointB.get(mid) < a) {
                    left = mid+1;
                    count = mid;
                } else {
                    right = mid-1;
                }
            }
            if(count > 0) {
                percent += count+1;
            }
        }

        return percent;
    }

    static void choice(int depth, int cur) {
        if(depth >= diceLen/2) {
            ArrayList<Integer> tempA = new ArrayList<>(res); // A가 고른 주사위
            ArrayList<Integer> tempB = new ArrayList<>();
            for(int i=0; i<diceLen; i++) {
                if(!tempA.contains(i)) tempB.add(i);
            }

            int percent = calWinner(tempA, tempB);
            System.out.println(percent);
            if(percent > maxPercent) {
                maxPercent = percent;
                for(int i=0; i<tempA.size(); i++) {
                    answer[i] = tempA.get(i)+1;
                }
            }
            return;
        }

        for(int i=cur; i<diceLen; i++) {
            res.add(i);
            choice(depth+1, i+1);
            res.remove(res.indexOf(i));
        }
    }

    public int[] solution(int[][] dice) {
        diceLen = dice.length;
        answer = new int[diceLen/2];
        this.dice = dice;
        res = new ArrayList<>();
        choice(0, 0);

        System.out.println(maxPercent);
        return answer;
    }

    public static void main(String[] args) {

        Pg258709 pg = new Pg258709();
        System.out.println(Arrays.toString(pg.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {3, 3, 3, 3, 4, 4}, {1, 3, 3, 4, 4, 4}, {1, 1, 4, 4, 5, 5}})));
    }
}
