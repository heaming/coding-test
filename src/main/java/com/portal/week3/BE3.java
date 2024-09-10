package com.portal.week3;

import java.util.Arrays;

public class BE3 {
    static int answer = 0;
    static int[] res;

    static void dfs(int[] arr, int depth, int cur, int sum, int k, int t) {
        if(depth >= k) {
            System.out.println(Arrays.toString(res));
            if(sum <= t) answer++;
        } else {
            int prev = 0;

            for(int i=cur; i<arr.length; i++) {
                if(prev == arr[i]) continue;
//                prev = arr[i];
                res[depth] = arr[i];
                dfs(arr, depth+1, i+1, sum+arr[i], k, t);
            }
        }
    }


    public int solution(int[] arr, int k, int t) {

        for(int i=k; i<=arr.length; i++) {
            res = new int[i];
            dfs(arr, 0, 0, 0, i, t);
        }

        return answer;
    }

    public static void main(String[] args) {
        BE3 be = new BE3();
        System.out.println(be.solution(new int[]{1,2,3,2},2,2));
    }
}
