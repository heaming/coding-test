package com.portal.week4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * @title 시간 관리
 * @url https://www.acmicpc.net/problem/1263
 * @tag 우선수위 큐
 * @since 2024-09-08
 */
public class Boj1263 {

    static int N;
    static Todo[] todos;

    static class Todo {
        int during;
        int due;

        public Todo(int during, int due) {
            this.during = during;
            this.due = due;
        }

        @Override
        public String toString() {
            return "Todo{" +
                    "during=" + during +
                    ", due=" + due +
                    '}';
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        todos = new Todo[N];
        PriorityQueue<Todo> que = new PriorityQueue<>(Comparator.comparingInt(o -> o.due));
        for(int i=0; i<N; i++) {
            st = new StringTokenizer(br.readLine());
            int during = Integer.parseInt(st.nextToken());
            int due = Integer.parseInt(st.nextToken());
            todos[i] = new Todo(during, due);
            que.offer(todos[i]);
        }

        int total = 0;
        int min = Integer.MAX_VALUE;

        while(!que.isEmpty()) {
            Todo cur = que.poll();
            total += cur.during;
            min = Math.min(min, cur.due - total);

            if(total > cur.due) {
                System.out.println(-1);
                return;
            }
        }


        System.out.println(min);

    }
}
