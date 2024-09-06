package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * 2024-08-23
 * https://www.acmicpc.net/problem/9251
 */
public class ReBoj9251 {
//    public class Main {

    static String s1;
    static String s2;
    static int[][] map;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        s1 = st.nextToken();
        st = new StringTokenizer(br.readLine());
        s2 = st.nextToken();
        map = new int[s1.length()+1][s2.length()+1];

        for(int i=1; i<=s1.length(); i++) {
            for(int j=1; j<=s2.length(); j++) {
                if(s1.charAt(i-1) == s2.charAt(j-1)) {
                    map[i][j] = map[i-1][j-1]+1;
                } else {
                    map[i][j] = Math.max(map[i-1][j], map[i][j-1]);
                }
            }
        }

        int answer = 0;
        for(int i=1; i<=s2.length(); i++) {
            answer = Math.max(answer, map[s1.length()][i]);
        }
        System.out.println(answer);

    }
}
