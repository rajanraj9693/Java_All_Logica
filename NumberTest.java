package com.logicalCodinTest.numberTest;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class NumberTest {

    public static void main(String[] args) {
        //1 .Remove the duplicate number from given Array
        int[] num = {10, 20, 30, 40, 50, 10, 20, 60};
        int[] remDup = Arrays.stream(num).distinct().toArray();
        System.out.println(Arrays.toString(remDup));
        // if elements in the list
        List<Integer> list = Arrays.asList(10, 20, 30, 40, 10, 20, 30, 50, 9);
        List<Integer> duplicateNum = list.stream().distinct()
                .collect(Collectors.toList());
        System.out.println(duplicateNum);
        //2 .count the duplicate number from Array
        Map<Integer, Long> count = list.stream()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(count);

        Map<Integer, Long> collect = Arrays.stream(num).boxed()
                .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        //System.out.println(collect);
        //Find the max number
        int max = list.stream().max(Integer::compare).orElse(null);
        //System.out.println(max);
        int maxNum = Arrays.stream(num).max().getAsInt();
        //System.out.println(maxNum);
        //Find Min number

        int min = list.stream().min(Integer::compare).orElse(null);
        //System.out.println(min);

        // Find First elements in java
        int findFirst = list.stream().findFirst().get();
        int firstElement = Arrays.stream(num).boxed().findFirst().get();

        //Last Elements
        int last = list.size() - 1;//find the
        //System.out.println(list.get(last));
        Integer lastElement = list.get(list.size() - 1);
        System.out.println(lastElement);

        //Find the Greater than 40
        List<Integer> greaterThan = list.stream().filter(i -> i > 30)
                .collect(Collectors.toList());
        System.out.println(greaterThan);

        int[] greater = Arrays.stream(num).filter(i -> i > 30).toArray();
        //System.out.println(Arrays.toString(greater));

        //Find second-Highest elements

        Integer secHighet = list.stream().sorted(Comparator.reverseOrder())
                .skip(1).findFirst().orElse(null);
        System.out.println(secHighet);
        List<Integer> secondHighest = list.stream().distinct().sorted(Comparator.reverseOrder())
                .skip(1).limit(1).collect(Collectors.toList());
        System.out.println(secondHighest);

        //Second Lowest elements
        List<Integer> secondLowest = list.stream().sorted().distinct().skip(1).limit(1)
                .collect(Collectors.toList());
        System.out.println(secondLowest);

        //Find the sorted order
        List<Integer> sorted = list.stream()
                .sorted().collect(Collectors.toList());
        System.out.println(sorted);

        //Reverse order after sorted
        List<Integer> reverseOrder = list.stream()
                .sorted(Collections.reverseOrder())
                .collect(Collectors.toList());
        System.out.println(reverseOrder);

        //Find Odd or Even Number

        List<Integer> even = list.stream()
                .filter(integer -> integer % 2 == 0)
                .collect(Collectors.toList());
        //System.out.println(even);

        List<Integer> odd = list.stream().filter(integer -> integer % 2 != 0)
                .collect(Collectors.toList());
        //System.out.println(odd);

        //even or odd
        List<Integer> evenOdd = list.stream().filter(i -> i % 2 == 0 && i % 3 == 0)
                .collect(Collectors.toList());
        System.out.println(evenOdd);

        //Prime number using java 8 Asked in Virtusa,
        IntStream.rangeClosed(2,100)
                .filter(primeNum->IntStream.rangeClosed(2,(int)Math.sqrt(primeNum))
                        .noneMatch(i->primeNum% i==0))
                .forEach(primeNum-> System.out.println(primeNum+" "));

    }
}



