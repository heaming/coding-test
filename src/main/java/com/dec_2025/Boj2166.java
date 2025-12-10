package com.dec_2025;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * @since 2025-12-10
 * @title 다각형의 면적
 * https://www.acmicpc.net/problem/2166
 * @tag dp
 * 시간 제한	메모리 제한	제출	정답	맞힌 사람	정답 비율
 * 2 초	128 MB	49060	15688	12278	30.652%
 * 문제
 * 2차원 평면상에 N(3 ≤ N ≤ 10,000)개의 점으로 이루어진 다각형이 있다. 이 다각형의 면적을 구하는 프로그램을 작성하시오.
 *
 * 입력
 * 첫째 줄에 N이 주어진다. 다음 N개의 줄에는 다각형을 이루는 순서대로 N개의 점의 x, y좌표가 주어진다. 좌표값은 절댓값이 100,000을 넘지 않는 정수이다.
 *
 * 출력
 * 첫째 줄에 면적을 출력한다. 면적을 출력할 때에는 소수점 아래 둘째 자리에서 반올림하여 첫째 자리까지 출력한다.
 *
 * 예제 입력 1
 * 4
 * 0 0
 * 0 10
 * 10 10
 * 10 0
 * 예제 출력 1
 * 100.0
 */
public class Boj2166 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        arr = new int[N+1];
        st = new StringTokenizer(br.readLine());
        for(int i=1; i<=N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int[] up = new int[N+1];
        for(int i=1; i<=N; i++) {
            up[i] = 1;

            for(int j=1; j<i; j++) {
                if(arr[i] > arr[j]) {
                    up[i] = Math.max(up[j]+1, up[i]);
                }
            }
        }

        int[] down = new int[N+1];
        for(int i=N; i>0; i--) {
            down[i] = 1;

            for(int j=N; j>i; j--) {
                if(arr[i] > arr[j]) {
                    down[i] = Math.max(down[j]+1, down[i]);
                }
            }
        }

        int max = 0;
        for(int i=1; i<=N; i++) {
            max = Math.max(max, up[i]+down[i]);
        }

        System.out.println(max-1);
        br.close();
    }
}
