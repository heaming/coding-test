package com.portal.week4;

/**
 * @title 수식 복원하기
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/340210
 * @tag
 * @since 2024-09-08
 */
public class Pg340210 {
    public String[] solution(String[] expressions) {
        String[] answer = {};

        int max = -1;

        for(String ex : expressions) {

            String[] arr = ex.split(" ");
            for(int i=0; i<arr.length; i++) {
                if(i%2 == 1) continue;
                if(arr[i].charAt(0) == 'X') continue;

                for(int j=0; j<arr[i].length(); j++) {
                    max = Math.max(Integer.parseInt(String.valueOf(arr[i].charAt(j)))+1, max);
                }
            }
        }

        System.out.println(max);
        return answer;
    }

    public static void main(String[] args) {
        Pg340210 p = new Pg340210();
        System.out.println(p.solution(new String[]{"14 + 3 = 17", "13 - 6 = X", "51 - 5 = 44"}));
        System.out.println(p.solution(new String[]{"1 + 1 = 2", "1 + 3 = 4", "1 + 5 = X", "1 + 2 = X"}));
    }

}
