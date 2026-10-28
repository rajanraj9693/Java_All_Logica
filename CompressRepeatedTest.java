package com.logicalCodinTest.charTest;

public class CompressRepeatedTest {
    public static void main(String[] args) {
        String s = "AAABBBCCDDBBCCD";
        StringBuilder out = new StringBuilder();
        for (int i=0; i<s.length();){
            int j=i;
            while (j<s.length() && s.charAt(i)==s.charAt(j)) j++;
            out.append(s.charAt(i)).append(j-i);
            i=j;
        }
        System.out.println(out);
    }
}


