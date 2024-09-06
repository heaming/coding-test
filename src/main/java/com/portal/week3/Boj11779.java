package com.portal.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

/**
 * @title 최소비용 구하기 2
 * @since 2024-08-23
 * @url https://www.acmicpc.net/problem/11779
 * @tag 다익스트라 스택
 */
public class Boj11779 {
//    public class Main{
    static int n;
    static int m;
    static List<Info>[] graph;
    static int[] prev;
    static long[] dist;
    static int start;
    static int end;
    static StringBuilder sb = new StringBuilder();

    static class Info {
        int to;
        long cost;

        public Info(int to, long cost) {
            this.to = to;
            this.cost = cost;
        }
    }

    static void dijkstra(int start) {

        PriorityQueue<Info> que = new PriorityQueue<>(Comparator.comparingLong(i -> i.cost));
        dist[start]= 0;
        que.offer(new Info(start, 0));

        while(!que.isEmpty()) {
            Info cur = que.poll();

            if(dist[cur.to] != cur.cost) continue;

            for(Info next : graph[cur.to]) {

                if(dist[cur.to]+next.cost >= dist[next.to]) continue;
                dist[next.to] = dist[cur.to]+next.cost;
                prev[next.to] = cur.to;
                que.offer(new Info(next.to, dist[next.to]));
            }
        }
    }

    static void findRoute() {
        Stack<Integer> stack = new Stack<>();
        stack.push(end);

        while(stack.peek() != start) {
            stack.push(prev[stack.peek()]);
        }

        System.out.println(stack.size());

        while(!stack.isEmpty()) {
            sb.append(stack.pop()+" ");
        }
        System.out.println(sb);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        dist = new long[n+1];
        prev = new int[n+1];
        graph = new List[n+1];
        for(int i=1; i<=n; i++) {
            graph[i] = new ArrayList<>();
            dist[i] = 1000L*100000*100000+3;
        }
        for(int i=1; i<=m; i++){
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());
            int cost = Integer.parseInt(st.nextToken());

            graph[start].add(new Info(end,cost));
        }
        st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        end = Integer.parseInt(st.nextToken());

        dijkstra(start);
        System.out.println(dist[end]);
        findRoute();

    }

}
