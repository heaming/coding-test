package com.portal.week4;

/**
 * @title PCCP 2 - 퍼즐 게임 챌린지
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/340212
 * @tag 이분탐색
 * @since 2024-09-08
 */
public class Pg340212 {
    public int solution(int[] diffs, int[] times, long limit) {
        long answer = 0;

        long left = 1;
        long right = limit;

        while(left <= right) {

            long mid = (left+right)/2;
            long used = 0;

            for(int i=0; i<diffs.length; i++) {
                if(diffs[i] <= mid) {
                    used += times[i];
                } else {
                    used += (times[i-1]+times[i])*(diffs[i]-mid)+times[i];
                }
            }

            if(used <= limit)  {
                answer = mid;
                right = mid-1;
            } else {
                left = mid+1;
            }

        }

        return (int)answer;
    }

    public static void main(String[] args) {
        Pg340212 p = new Pg340212();
        System.out.println(p.solution(new int[]{1,4,4,2},new int[]{6,3,8,2}, 59));
    }
}
