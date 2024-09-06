package com.portal.week3;

import java.util.Arrays;

public class BE1 {
    public int solution(int[] goods, int[] boxes){
        int answer = 0;

        Arrays.sort(goods);
        Arrays.sort(boxes);

        for(int left=0, right=0; left<goods.length; left++) {
            while(right<boxes.length) {
                if(goods[left] <= boxes[right]) {
                    answer++;
                    right++;
                    break;
                } else {
                    right++;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        BE1 be = new BE1();
        System.out.println(be.solution(new int[]{5,3,7},new int[]{3,7,6}));
    }
}
