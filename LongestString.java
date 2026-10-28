package com.logicalCodinTest.charTest;

public class LongestString {
    public static void main(String[] args) {
        String r="A,AA,AAA,AAAA,B,B";
        String[] r1 = r.split(",");

        String m="";
        for (int i = 0; i < r1.length-1 ; i++) {
            if (r1[i].length() > m.length()){
                m=r1[i];
            }
        }
        System.out.println(m+"  "+m.length());
    }
}
