package com.portal.week3;

import java.util.Arrays;

public class BE2 {
    public long[] solution(long n)
    {
        long []answer = {Long.MAX_VALUE,Long.MIN_VALUE};
        long [][] dy = {{0, 0, 0, 0, 0, 1, 1},
                {0, 0, 0, 0, 1, 2, 1},
                {0, 0, 0, 1, 2, 2, 1},
                {0, 0, 1, 2, 2, 2, 1},
                {0, 1, 2, 2, 2, 2, 1},
                {1, 2, 2, 2, 2, 2, 1},
                {2, 2, 2, 2, 2, 2, 2}};


        long[] arr = new long[7];
        for(int i=0; i<7; i++) {
            System.out.println((int) n%7);
            System.out.println((int) n/7);
            arr[i] = dy[(int) n%7][i] + dy[6][i]*((int) (n-1)/7);
        }
        System.out.println(Arrays.toString(arr));
        float x = 15/4;
        System.out.println(x);

        return answer;
    }

    /*
    * {{0, 0, 0, 0, 0, 1, 1}, 7/7 = 0
    * {0, 0, 0, 0, 1, 2, 1},
    * {0, 0, 0, 1, 2, 2, 1},
    * {0, 0, 1, 2, 2, 2, 1},
    * {0, 1, 2, 2, 2, 2, 1},
    * {1, 2, 2, 2, 2, 2, 1},
    * {2, 2, 2, 2, 2, 2, 2}} 7일 기준
    * =====================
    * 2 2 2 2 2 3 3 8일 기준 8/7 = 1
    * 2 2 2 2 3 4 3
    * */
    public static void main(String[] args) {
        BE2 be = new BE2();
        System.out.println(Arrays.toString(be.solution(14)));
    }
}
