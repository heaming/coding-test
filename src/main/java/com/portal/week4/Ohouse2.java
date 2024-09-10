package com.portal.week4;

public class Ohouse2 {

    static int solution(int[] happiness) {
        int res = 0;
        int[] happy = new int[happiness.length+1];
        int[] unhappy = new int[happiness.length+1];
        int day = 0;

        for(int i=0; i<happiness.length; i++) {

            if(happiness[i] > 8) {
                happy[i+1] = happy[i]+1;
                unhappy[i+1] = unhappy[i];
            } else {
                unhappy[i+1] = unhappy[i]+1;
                happy[i+1] = happy[i];
            }

            if(unhappy[i+1] >= happy[i+1]) {
                res = Math.max(day, res);
                happy[i+1] = 0;
                unhappy[i+1] = 0;
                day = 0;
            } else {
                day++;
            }
        }

        return res;
    }

    public static void main(String[] args) {

        Ohouse2 o = new Ohouse2();
        System.out.println(o.solution(new int[]{9,10,6,0,4,6,10}));
    }
}
