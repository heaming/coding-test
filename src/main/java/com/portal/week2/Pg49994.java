package com.portal.week2;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;


/**
 * https://school.programmers.co.kr/learn/courses/30/lessons/49994
 */

public class Pg49994 {
    static class Solution {
        static int[] dn = {1,0,-1,0}; // (5,5)
        static int[] dm = {0,1,0,-1};
        static Map<Character, int[]> dirMap = new HashMap<>();

        static class Node {
            int m;
            int n;
            int d;

            public Node(int n, int m, int d) {
                this.n = n;
                this.m = m;
                this.d = d;
            }
        }

        public int solution(String dirs) {
            int answer = 0;
            boolean[][][] map = new boolean[11][11][4];
            dirMap.put('U',new int[]{0,2});
            dirMap.put('R',new int[]{1,3});
            dirMap.put('D',new int[]{2,0});
            dirMap.put('L',new int[]{3,1});

            Node cur = new Node(5,5,-1);

            for(int i=0; i<dirs.length(); i++) {
                int[] dir = dirMap.get(dirs.charAt(i));

                int nn = cur.n+dn[dir[0]];
                int nm = cur.m+dm[dir[1]];

                if(nn<0 || nn>=11 || nm<0 || nm>=11) continue;

                if(!map[nn][nm][dir[0]] && !map[cur.n][cur.m][dir[1]]){
                    answer++;
                    map[nn][nm][dir[0]] = true;
                    map[cur.n][cur.m][dir[1]] = true;
                }

                cur = new Node(nn,nm,dir[0]);
            }

            return answer;
        }
    }
}
