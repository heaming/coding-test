package com.portal.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 2024-08-23
 * https://school.programmers.co.kr/learn/courses/30/lessons/258709
 */
public class RePg258709 {

    static int n;
    static ArrayList<Integer> res;
    static ArrayList<Integer> aPoint;
    static ArrayList<Integer> bPoint;
    static int[][] dice;
    static int[] answer;
    static int max = -1;

    static void winningRate(List<Integer> choice, int depth, int sum, ArrayList<Integer> points){
        if(depth >= choice.size()) {
            points.add(sum);
        } else {
            for(int i=0; i<6; i++) {
                winningRate(choice, depth+1, sum+dice[choice.get(depth)][i], points);
            }
        }
    }

    static int calPointA(List<Integer> diceA, List<Integer> diceB) {

        aPoint = new ArrayList<>();
        bPoint = new ArrayList<>();

        winningRate(diceA, 0,0, aPoint);
        winningRate(diceB, 0,0, bPoint);

        Collections.sort(bPoint);

        int percent = 0;

        for(int a : aPoint) {

            int left = 0;
            int right = bPoint.size()-1;
            int count = -1;

            while(left <= right) {
                int mid = (left+right)/2;

                if(bPoint.get(mid) < a) {
                    count = mid;
                    left = mid+1;
                } else {
                    right = mid-1;
                }
            }
            if(count > 0) percent += count+1;
        }

        return percent;
    }

    static void dfs(int resIdx, int cur) {

        if(resIdx >= n/2) {
            // 승률 계산
            ArrayList<Integer> resA = new ArrayList<>(res);
            ArrayList<Integer> resB = new ArrayList<>();

            for(int i=0; i<n; i++) {
                if(!resA.contains(i)) resB.add(i);
            }

            int percent = calPointA(resA, resB);
            if(percent > max) {
                max = percent;
                for(int i=0; i<resA.size(); i++) {
                    answer[i] = res.get(i)+1;
                }
            }
        } else {
            for(int i=cur; i<n; i++) {
                res.add(i);
                dfs(resIdx+1, i+1);
                res.remove(res.indexOf(i));
            }
        }
    }


    public int[] solution(int[][] dice) {
        n = dice.length;
        answer = new int[n/2];
        res = new ArrayList<>();
        this.dice = dice;

        // 뽑기
        dfs(0,0);

        return answer;
    }

    public static void main(String[] args) {
        RePg258709 pg = new RePg258709();
        System.out.println(Arrays.toString(pg.solution(new int[][]{{1, 2, 3, 4, 5, 6}, {2, 2, 4, 4, 6, 6}})));
    }

}
