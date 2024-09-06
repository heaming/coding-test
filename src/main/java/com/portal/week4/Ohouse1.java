package com.portal.week4;

public class Ohouse1 {

    static boolean solution(String target, String typed) {
        int i = 0;
        int j = 0;

        boolean flag = true;

        while((i<target.length() || j<typed.length()) && flag ) {

            if(i>=target.length()) {
                if(target.charAt(i-1) != typed.charAt(j)) {
                    flag = false;
                }
                j++;
            } else if(j>=typed.length()) {
                if(typed.charAt(j-1) != target.charAt(i)) {
                    flag = false;
                }
                i++;
            } else if(target.charAt(i) == typed.charAt(j)) {
                j++;
            } else {
                i++;
            }
        }

        return flag;
    }
    public static void main(String[] args) {
        Ohouse1 o = new Ohouse1();
        System.out.println(o.solution("ohouse","oohoussse"));
        System.out.println(o.solution("bucketplace","puckeetplacdeee"));
    }
}
