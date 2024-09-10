package com.portal.week3;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @title n+1 카드게임
 * @since 2024-08-20
 * @url https://school.programmers.co.kr/learn/courses/30/lessons/258707
 * @tag 구현
 */
public class Pg258707 {
    static List<Integer> hand = new ArrayList<>();
    static List<Integer> left = new ArrayList<>();
    static int n;

    static boolean makeN(List<Integer> a, List<Integer> b) {
        for(int i=0; i<a.size(); i++) {
            for(int j=0; j<b.size(); j++) {
                if(Objects.equals(a.get(i), b.get(j))) continue;
                if(a.get(i)+b.get(j) == n+1) {

                    int aa = a.get(i);
                    int bb = b.get(j);

                    a.remove(Integer.valueOf(aa));
                    b.remove(Integer.valueOf(bb));
                    return true;
                }
            }
        }
        return false;
    }

    public int solution(int coin, int[] cards) {
        int answer = 1;
        int idx = cards.length/3;
        n = cards.length;

        for(int i=0; i<idx; i++) {
            hand.add(cards[i]);
        }
        System.out.println(hand);

        while(idx < n) {

            // 뽑기 (버린다 / 갖는다)
            left.add(cards[idx++]);
            left.add(cards[idx++]);

            // 2장 주기 -> 합이 n
            if(hand.size() > 1 && makeN(hand, hand)) {
                answer++;
            } else if(coin > 0 && makeN(hand, left)) {
                answer++;
                coin--;
            } else if(coin > 1 && makeN(left, left)) {
                answer++;
                coin -= 2;
            } else{
                break;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Pg258707 pg = new Pg258707();
        System.out.println(pg.solution(4, new int[]{3, 6, 7, 2, 1, 10, 5, 9, 8, 12, 11, 4}));
    }
}
