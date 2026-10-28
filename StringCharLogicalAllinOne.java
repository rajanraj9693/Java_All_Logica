package com.logicalCodinTest.numberTest;

import java.util.stream.Collectors;

public class StringCharLogicalAllinOne {
    public static void main(String[] args) {
        //Remove Duplicate
        String str = "RajanPaswan";
        str.chars().mapToObj(item->(char)item)
                .collect(Collectors.toSet()).forEach(System.out::print);

        //Count occaran
    }
}
