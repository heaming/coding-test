package com.portal.week2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * @date 2024-08-17
 * @title N과 M 1
 * @tag dfs 수열
 * @link https://www.acmicpc.net/problem/15649
 */
public class Boj15649 {

//    public class Main {
    static int N;
    static int M;
    static List<ArrayList<Integer>> combis = new ArrayList<>();

    static void dfs(boolean[] visited, ArrayList<Integer> combi) {
        if(combi.size() >= M) {
            ArrayList<Integer> temp = new ArrayList<>(combi);
            combis.add(temp);
        } else {
            for(int i=1; i<=N; i++) {
                if(!visited[i]) {
                    visited[i] = true;
                    combi.add(i);
                    dfs(visited, combi);
                    combi.remove(combi.indexOf(i));
                    visited[i] = false;
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        dfs(new boolean[N+1], new ArrayList<>());

        for(List<Integer> list : combis) {
            for(int i : list) {
                System.out.print(i+" ");
            }
            System.out.print("\n");
        }
    }
//    }
}
