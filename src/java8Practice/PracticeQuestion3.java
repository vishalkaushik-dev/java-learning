package java8Practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

public class PracticeQuestion3 {



    public static void main(String[] args) {

        List<Integer> ls = Arrays.asList(2,531,11,6354,13);
        int maxNumber = ls.stream().max(Integer::compare).orElseThrow();
        System.out.println(maxNumber);

        ls.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());

        String input = "swiss";
        Character result = input.chars().mapToObj(ch -> (char) ch)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet().stream()
                .filter(e -> e.getValue() == 1)
                .map(entry -> entry.getKey())
                .findFirst()
                .orElse(null);
        System.out.println("Find the first non-repeated character in a string " + result);

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        int sum = numbers.stream().reduce(0, Integer::sum);
        System.out.println(sum);

        List<Integer> numbers1 = Arrays.asList(1, 2, 3, 4, 2, 5, 1);
        Set<Integer> unique = new HashSet<>();
        Set<Integer> duplicates = numbers1.stream()
                .filter(n -> !unique.add(n))
                .collect(Collectors.toSet());
        System.out.println("Duplicate numbers : " + duplicates);

        // Flatten a List of Lists
        List<List<Integer>> listOfLists = Arrays.asList(
                Arrays.asList(1, 2, 3),
                Arrays.asList(4, 5),
                Arrays.asList(6, 7, 8, 9)
        );

        List<Integer> flattenedList = listOfLists.stream().flatMap(Collection::stream).toList();
        System.out.println("Flattened list : " + flattenedList);

        // Concatenate all strings in a list into a single string.
        List<String> words = Arrays.asList("Stream", "API", "is", "powerful");
        String concatenatedString = words.stream().collect(Collectors.joining(" "));
        System.out.println("Concatenated string : " + concatenatedString);

        List<String> words1 = Arrays.asList("Java", "Stream", "API", "Development");
        String longest = words1.stream().max(Comparator.comparingInt(String::length)).get();
        System.out.println("Longest word : " + longest);

        List<Integer> numbers2 = Arrays.asList(1, 2, 3, 4, 5);
        int sum1 = numbers2.parallelStream().mapToInt(Integer::intValue).sum();
        System.out.println(sum1);

        // Convert a list of strings into a map with the string as the key and its length as the value.
        List<String> words2 = Arrays.asList("Java", "Stream", "API");
        Map<String,Integer> wordLengthMap = words2.stream().collect(Collectors.toMap(word -> word, String::length));
        System.out.println(wordLengthMap);
    }
}
