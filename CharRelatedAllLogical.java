package com.logicalCodinTest.charTest;

import java.util.*;
import java.util.stream.Collectors;

public class CharRelatedAllLogical {
    public static void main(String[] args) {

        //Q1 .Remove Duplicate word from give string using java 8

        String str = "RajanPaswan";
        str.chars().mapToObj(i -> (char) i).collect(Collectors.toSet())
                .forEach(System.out::print);

        //Q2. Count the Occurrences of Character
        String findOccurrence = "MyNameIsRajan";
        Map<Character, Long> map = findOccurrence.chars()
                .mapToObj(i -> (char) i).collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        System.out.println(map);
        map.forEach((k, v) -> {
            System.out.println(k + "=" + v);
        });

        //Q3. Reverse of character
        String reverseChar = "Rajan is My name";
        StringBuffer sb = new StringBuffer(reverseChar);
        sb.reverse();
        System.out.println(sb);

        //Q4. Reverse of Word
        String reverseWord = "Rajan is My name";
        List<String> list = Arrays.asList(reverseWord.split(" "));// if space not provide in the double inverted comma then below lines.
        Collections.reverse(list);
        System.out.println(list);
        String word = String.join(" ", list);
        System.out.println("Reverse oder is= " + word);

        //Q6. First non repeated character
        String input = "RajanPaswan";
        List<Character> result = input.chars().mapToObj(c -> (char) c)
                .filter(i -> input.indexOf(i) == input.lastIndexOf(i)).toList();
        System.out.println("First Non " + result);

        // 2nd Way Non-Repeated character
        String inputStr = "Programming";
        Character resultChar = inputStr.chars().mapToObj(c -> (char) c)
                .filter(c -> inputStr.indexOf(c) == inputStr.lastIndexOf(c)).findFirst().orElse(null);
        if (resultChar == null) {
            System.out.println("====First Non Repeated Character" + resultChar);
        } else {
            System.out.println("===No Non Repeated Character Found" + resultChar);
        }

        //All Non repeated Character
        List<Character> nonRepeatedChar = inputStr.chars().mapToObj(c -> (char) c)
                .collect(Collectors.groupingBy(i -> i, LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(entry -> entry.getValue() == 1).map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println("====Non Repeated Charater " + nonRepeatedChar);

        //Q7. Palindrome

        String palindrome = "madam";
        String reverse = new StringBuffer(palindrome).reverse().toString();
        System.out.println(reverse);
        if (palindrome.equals(reverse)) {
            System.out.println("Palindrome");
        } else {
            System.out.println("Not Palindrome");
        }

        // Write a program to compress a string
        // Ex:- AAABBBCCDDBBCCD
        // Output :-
        // A3B3C2D2B2C2D1 need to write

        //Problem statement: Given an array of strings, group all strings that are anagrams of each other.
        // Two strings are anagrams if they contain the same characters with the same frequencies,
        // regardless of order.

        //        Input:
        //["eat", "tea", "tan", "ate", "nat", "bat"]
        //        Expected output:
        //[["eat", "tea", "ate"], ["tan", "nat"], ["bat"]]

        String[] strs = {
                "eat", "tea", "tan", "ate", "nat", "bat"
        };
        Map<String, List<String>> grouped = Arrays.stream(strs)
                .collect(Collectors.groupingBy(s -> {
                            char[] chars = s.toCharArray();
                            Arrays.sort(chars);
                            return new String(chars);
                        },
                        LinkedHashMap::new,
                        Collectors.toList()
                ));
        List<List<String>> anagram =
                new ArrayList<>(grouped.values());
        System.out.println("anagram===" + anagram);

        //Reverse String
        String s = "Java";
        System.out.println(new StringBuilder(s).reverse());

        //Count Vowels
        String vowels = "education";
        long vowelsCount = vowels.toLowerCase().chars()
                .filter(c -> "aeiou".indexOf(c) >= 0)
                .count();
        System.out.println(vowelsCount);

        //Count consonent
        String consonent = "Java";
        long countConsonent = consonent.toLowerCase().chars()
                .filter(Character::isLetter)
                .filter(c -> "aeiou".indexOf(c) < 0)
                .count();
        System.out.println(countConsonent);

        //Count character in String
        String count = "Spring";
        System.out.println(count.length());

        //convert to upper case
        System.out.println("java developer".toUpperCase());

        //convert To lower case
        System.out.println("JAVA".toLowerCase());

        //Remove all spaces
        System.out.println("Java Developer".replace(" ", ""));

        //Remove all occurrences of a character
        System.out.println("banana".replace("a", ""));

        //Count occurrences of a character a
        String occurrences = "banana";
        long occurrencesOfA = occurrences.chars().filter(c -> c == 'a').count();
        System.out.println(occurrencesOfA);

        //Check whether a string contains a word
        System.out.println("Java Spring Boot".contains("Spring"));

        //Replace a word
        System.out.println("I like Java".replace("Java", "Spring"));

        //Check whether a string is empty
        String s1 = "";
        System.out.println(s1.isEmpty());

        //Find duplicate character
        String duplicateFind = "programming";
        Map<Character, Long> freq = duplicateFind.chars()
                .mapToObj(c -> (char) c)
                .collect(java.util.stream.Collectors.groupingBy(
                        c -> c, java.util.LinkedHashMap::new,
                        java.util.stream.Collectors.counting()));

        freq.forEach((c, n) -> {
            if (n > 1) System.out.println(c + " = " + n);
        });

        //Find the maximum-occurring character
        Map<Character, Long> frequency = "banana".chars()
                .mapToObj(c -> (char) c)
                .collect(java.util.stream.Collectors.groupingBy(
                        c -> c, java.util.stream.Collectors.counting()));

        Character result2 = frequency.entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
        System.out.println(result2);

        //Find the minimum-occurring character
        Map<Character, Long> freq1 = "banana".chars()
                .mapToObj(c -> (char) c)
                .collect(java.util.stream.Collectors.groupingBy(
                        c -> c, java.util.stream.Collectors.counting()));

        Character result3 = freq1.entrySet().stream()
                .min(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey).orElse(null);
        System.out.println(result3);

        //Count digits in a string
        long countDigit = "Java123".chars()
                .filter(Character::isDigit).count();
        System.out.println(countDigit);

        //Count letters, digits and special characters
        String countLetterDigit = "Abc123@";
        long letters = countLetterDigit.chars().filter(Character::isLetter).count();
        long digits = countLetterDigit.chars().filter(Character::isDigit).count();
        long special = countLetterDigit.chars()
                .filter(c -> !Character.isLetterOrDigit(c)).count();

        System.out.println(letters + " " + digits + " " + special);

        //VVI Find the longest word
        String result4 = Arrays.stream(
                        "Java SpringBoot Microservices".split("\\s+"))
                .max(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(result4);

        //Find the shortest word
        String result5 = java.util.Arrays.stream(
                        "Java Spring SQL".split("\\s+"))
                .min(Comparator.comparingInt(String::length))
                .orElse("");
        System.out.println(result5);

        // Find the longest common prefix
        String[] a = {"flower", "flow", "flight"};
        String prefix = a[0];

        for (int i = 1; i < a.length; i++) {
            while (!a[i].startsWith(prefix)) {
                prefix = prefix.substring(0, prefix.length() - 1);
            }
        }
        System.out.println(prefix);

        //Find the longest substring without repeating characters
        String substring = "abcabcbb";
        Set<Character> set = new HashSet<>();
        int left = 0, max = 0;

        for (int right = 0; right < substring.length(); right++) {
            while (set.contains(substring.charAt(right))) {
                set.remove(substring.charAt(left++));
            }
            set.add(substring.charAt(right));
            max = Math.max(max, right - left + 1);
        }
        System.out.println(max);

        //Compress repeated characters
        String s3 = "AAABBBCCD";
        StringBuilder out = new StringBuilder();

        for (int i = 0; i < s3.length(); ) {
            int j = i;
            while (j < s3.length() && s3.charAt(i) == s3.charAt(j)) j++;
            out.append(s3.charAt(i)).append(j - i);
            i = j;
        }
        System.out.println(out);

        // Expand a compressed string
        String s4 = "A3B2";
        StringBuilder output = new StringBuilder();

        for (int i = 0; i < s4.length(); i += 2) {
            char ch = s4.charAt(i);
            int count3 = Character.getNumericValue(s4.charAt(i + 1));
            for (int j = 0; j < count3; j++) output.append(ch);
        }
        System.out.println("expanded===" + output);


        //VVI Capitalize the first letter of each word
        String result6 = java.util.Arrays.stream(
                        "java developer".split("\\s+"))
                .map(w -> w.substring(0, 1).toUpperCase()
                        + w.substring(1))
                .collect(java.util.stream.Collectors.joining(" "));
        System.out.println(result6);

        //
//        List<String> str3 = Arrays.asList(
//                "@Test", "Rajan", "@Test", "mock",
//                "+", "@Test", "mock", "Jann");

        // Asked in IBM
        String findDup = "@Test,Rajan,@Test,mock@Test,mock,Jann,"
                + "@Test ,Jann,Sam";
        Arrays.stream(findDup.split(",")).map(String::trim)
                .collect(Collectors.groupingBy(
                        i -> i, LinkedHashMap::new, Collectors.counting()))
                .forEach((key, value) -> {
                    if (value > 1) {
                        System.out.println(key + " " + value);
                    }
                });

    }
}


