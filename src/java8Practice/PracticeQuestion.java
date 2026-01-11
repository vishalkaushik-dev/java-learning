package java8Practice;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.*;

public class EvenNumber {
    public static void main(String[] args) {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5);

        ls.stream()
                .filter((item) -> item%2 != 0)
                .forEach(System.out::println);

        /* When numbers are given as Array int[] arr = {10,15,8,49,25,98,32}; */

//        int[] arr = {1, 2, 3, 4, 5};
//        Map<Boolean, List<Integer>> list = Arrays.stream(arr).boxed().collect(Collectors.partitioningBy(i -> i % 2 == 0));
//        System.out.println(list);
    }
}
