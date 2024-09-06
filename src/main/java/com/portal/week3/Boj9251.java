package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * @title LCS
 * @since 2024-08-21
 * @url https://www.acmicpc.net/problem/9251
 * @tag 문자열 lsc
 */
public class Boj9251 {
//    public class Main {

    static String s1;
    static String s2;
    static int[][] lcs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s1 = " "+st.nextToken();
        st = new StringTokenizer(br.readLine());
        s2 = st.nextToken();
        lcs = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++){
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    lcs[i][j] = lcs[i-1][j-1]+1;
                } else {
                    lcs[i][j] = Math.max(lcs[i-1][j], lcs[i][j-1]);
                }
            }
        }

        int max = -1;
        for(int last : lcs[s1.length()]) {
            max = Math.max(max, last);
        }

        System.out.println(max);
    }

//    }
}
