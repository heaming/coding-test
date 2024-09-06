package com.portal.week3;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @title 도넛과 막대 그래프
 * @since 2024-08-19
 * @tag 그래프, 구현
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/258711
 */

public class Pg258711 {
    static List<Integer>[] graph;
    static int[] depth;
    static int len = Integer.MIN_VALUE;
    static boolean[] check = new boolean[1000001];

    public int[] solution(int[][] edges) {
        int start = 0;
        int donut = 0;
        int stick = 0;
        int eight = 0;

        for(int[] e : edges) {
            len = Math.max(len,Math.max(e[0], e[1]));
            check[e[0]] = true;
            check[e[1]] = true;
        }

        graph = new List[len+1]; // 나가는
        depth = new int[len+1]; // 들어오는
        for(int i=1; i<=len; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges) {
            graph[edge[0]].add(edge[1]);
            depth[edge[1]]++;
        }

        // 생성 정점 찾기 : 나가는 간선 2개 이상 / 들어오는 간선 0
        for(int i=1; i<=len; i++) {
            if(graph[i].size() >= 2 && depth[i] == 0) {
                start = i;
                break;
            }
        }

        for(int i : graph[start]) {
            depth[i]--;
        }

        // 막대 모양 찾기 -> 나가는 간선이 없는 edge
        for(int i=1; i<=len; i++) {
            if(i == start) continue;
            if(check[i] && graph[i].isEmpty()) stick++;
            if(graph[i].size() == 2 && depth[i] == 2) eight++;
        }

        donut = (graph[start].size() - stick - eight);

        int[] answer = new int[]{start, donut, stick, eight};

        return answer;
    }

    public static void main(String[] args) {
        Pg258711 pg = new Pg258711();
//        System.out.println(Arrays.toString(pg.solution(new int[][]{{4, 11}, {1, 12}, {8, 3}, {12, 7}, {4, 2}, {7, 11}, {4, 8}, {9, 6}, {10, 11}, {6, 10}, {3, 5}, {11, 1}, {5, 3}, {11, 9}, {3, 8}})));
        System.out.println(Arrays.toString(pg.solution(new int[][]{{1,5},{5,7},{13,1},{13,3},{3,3}})));
    }
}
