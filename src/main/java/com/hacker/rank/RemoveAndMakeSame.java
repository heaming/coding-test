package com.hacker.rank;

/**
 * 1.  두 개의 문자열이 주어집니다 (str1, str2)
 * 2.  str1은 str2보다 정확히 한 글자 더 깁니다
 * 3.  str1에서 하나의 문자를 제거해서 str2와 동일하게 만들 수 있는 모든 위치(인덱스)를 찾는 문제입니다
 * 4.  가능한 모든 인덱스를 오름차순으로 반환해야 합니다
 * 5.  만약 불가능한 경우 [-1]을 반환합니다
 * *   str1 = "abdgggda"
 * *   str2 = "abdggda"
 * *   이 경우 3, 4, 5 위치의 'g'를 제거하면 두 문자열이 같아지므로 \[3, 4, 5\]를 반환합니다
 */

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static java.util.stream.Collectors.joining;

/**
 * @since 2025-12-09
 * @url https://www.hackerrank.com/mock-interviews/software-engineer/coding/146248?version=2
 * @tag 문자열 비교
 * O(1) / O(1)
 */
public class RemoveAndMakeSame {
    public static List<Integer> getRemovableIndices(String str1, String str2) {
        List<Integer> result = new ArrayList<>();
        int n = str1.length();
        int m = str2.length();

        if (n != m + 1) {
            return List.of(-1);
        }

        boolean[] prefix = new boolean[n + 1];
        prefix[0] = true;

        for (int i = 0; i < m; i++) {
            if (prefix[i] && str1.charAt(i) == str2.charAt(i)) {
                prefix[i + 1] = true;
            }
        }

        System.out.println(Arrays.toString(prefix));
        boolean[] suffix = new boolean[n+1];
        suffix[n] = true;

        for (int i = m-1; i>=0; i--) {
            if (suffix[i+2] && str1.charAt(i+1) == str2.charAt(i)) {
                suffix[i+1] = true;
            }
        }
        System.out.println(Arrays.toString(suffix));

        for (int i=0; i<n; i++) {
            if(prefix[i] && suffix[i+1]) {
                result.add(i);
            }

        }

        if (result.isEmpty()) {
            return List.of(-1);
        }

        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        String str1 = bufferedReader.readLine();

        String str2 = bufferedReader.readLine();

        List<Integer> result = RemoveAndMakeSame.getRemovableIndices(str1, str2);

        System.out.println(
                result.stream()
                        .map(Object::toString)
                        .collect(joining("\n"))
        );

        bufferedReader.close();
    }
}
