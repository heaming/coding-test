package com.portal.week3;

import java.util.*;

/**
 * @title 가장 먼 노드
 * @tag 그래프 다익스트라
 * @since 2024-08-19
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/49189
 */
public class Pg49189 {

    static int[] dist;
    static List<Integer>[] graph;
    static int max = -1;

    static class Node {
        int idx;
        int cost;

        public Node(int idx, int cost) {
            this.idx = idx;
            this.cost = cost;
        }
    }

    static void dijkstra(int start) {

        PriorityQueue<Node> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.cost));
        dist[start] = 0;
        que.offer(new Node(start, 0));

        while(!que.isEmpty()) {
            Node cur = que.poll();
            max = Math.max(max, dist[cur.idx]);
            if(dist[cur.idx] != cur.cost) continue;

            for(int next : graph[cur.idx]) {
                if(cur.cost+1 >= dist[next]) continue;

                dist[next] = cur.cost+1;
                que.offer(new Node(next, dist[next]));
            }
        }
    }

    public int solution(int n, int[][] edge) {
        int answer = 0;
        dist = new int[n+1];
        graph = new List[n+1];
        for(int i=1; i<=n; i++){
            graph[i] = new ArrayList<>();
            dist[i] = 20000*50000+1;
        }

        for(int[] e : edge) {
            graph[e[0]].add(e[1]);
            graph[e[1]].add(e[0]);
        }

        dijkstra(1);
        for(int i=1; i<=n; i++) {
            if(max == dist[i]) answer++;
        }

        return answer;
    }

    public static void main(String[] args) {
        Pg49189 pg = new Pg49189();
        System.out.println(pg.solution(6,new int[][]{{3, 6}, {4, 3}, {3, 2}, {1, 3}, {1, 2}, {2, 4}, {5, 2}}));
    }
}
