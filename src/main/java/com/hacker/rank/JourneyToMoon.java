package com.hacker.rank;

import java.io.*;
import java.util.*;
import java.util.stream.*;
import static java.util.stream.Collectors.toList;

/**
 * @url https://www.hackerrank.com/challenges/journey-to-the-moon/problem?isFullScreen=true
 * @tag graph dfs
 */
class JourneyToMoon {

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    /*
     * Complete the 'journeyToMoon' function below.
     *
     * The function is expected to return an INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER n
     *  2. 2D_INTEGER_ARRAY astronaut
     */

    static int dfs(int idx, List<Integer>[] graph, boolean[] visited) {
        visited[idx] = true;
        int count = 1;

        for(int next : graph[idx]) {
            if (!visited[next]) {
                count += dfs(next, graph, visited);
            }
        }

        return count;
    }

    public static long journeyToMoon(int n, List<List<Integer>> astronaut) {
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++) {
            graph[i] = new ArrayList<>();
        }

        astronaut.forEach(p -> {
            int a = p.get(0);
            int b = p.get(1);
            graph[a].add(b);
            graph[b].add(a);
        });

        boolean[] visited = new boolean[n];
        List<Integer> countPerCountry = new ArrayList<>();

        for (int i=0; i<n; i++) {
            if (!visited[i]) {
                int count = dfs(i, graph, visited);
                countPerCountry.add(count);
            }
        }

        long answer = 0;
        long totalPeople = 0;

        for(int count : countPerCountry) {
            answer += (long) count * totalPeople;
            totalPeople += count;
        }

        return answer;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String[] firstMultipleInput = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

        int n = Integer.parseInt(firstMultipleInput[0]);

        int p = Integer.parseInt(firstMultipleInput[1]);

        List<List<Integer>> astronaut = new ArrayList<>();

        IntStream.range(0, p).forEach(i -> {
            try {
                astronaut.add(
                        Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                                .map(Integer::parseInt)
                                .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        long result = JourneyToMoon.journeyToMoon(n, astronaut);

        System.out.println(result);
        bufferedReader.close();
    }
}