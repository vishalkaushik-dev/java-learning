package java8Practice;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PracticeQuestion {

    // Question 1: Print odd numbers from a List
    private static void printOddNumbersFromList() {
        List<Integer> ls = Arrays.asList(1, 2, 3, 4, 5);

        ls.stream()
                .filter(item -> item % 2 != 0)
                .forEach(System.out::println);

//        Partition even and odd numbers from an array
        int[] arr = {10, 15, 8, 49, 25, 98, 32};

        Map<Boolean, List<Integer>> result =
                Arrays.stream(arr)
                        .boxed()
                        .collect(Collectors.partitioningBy(i -> i % 2 == 0));

        System.out.println(result);
    }

    // Question 2: NumberStartingWithOne
    private static void printNumberStartingWithOne() {
        List<Integer> ls = Arrays.asList(1,41,16,23,91,122);

        ls.stream()
                .map(s -> s + "") //convert int to string
                .filter(s -> s.startsWith("1"))
                .forEach(System.out::println);

//        When numbers are given as Array
        int[] arr = {10,15,8,49,25,98,32};
        List<String> list = Arrays.stream(arr).boxed()
                .map(s -> s + "")
                .filter(s -> s.startsWith("1"))
                .collect(Collectors.toList());

        System.out.println(list); // output: [10, 15]
    }

    // Question 3: print duplicated element
    private static void printDuplicatesNumber() {
        System.out.println("Duplicates numbers are : ");
        List<Integer> ls = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>();
        ls.stream()
                .filter(item -> !set.add(item))
                .forEach(System.out::println);
    }

    private static void printUniquesNumber() {
        System.out.println("Unique numbers are : ");
        List<Integer> ls = Arrays.asList(10,15,8,49,25,98,98,32,15);

        ls.stream()
                .distinct()
                .forEach(System.out::println);
    }

    private static void getDataWithoutDuplicates() {
        System.out.println("Data without duplicate numbers are : ");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        Set<Integer> set = new HashSet<>(myList);

        // Convert the set back to a list if needed
        List<Integer> uniqueData = set.stream().toList();

        // Print the unique elements
        uniqueData.forEach(System.out::println);
    }

    private static void findFirstElement() {
        System.out.println("Find first element is : ");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);

        myList.stream()
                .findFirst()
                .ifPresent(System.out::println);
    }

    private static void findTotalNumberOfElements(){
        System.out.println("Find the total number of elements is : ");

        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        long count =  myList.stream()
                .count();
        System.out.println(count);
    }

    private static void findMaxElement() {
        System.out.println("Find the max element is : ");
        List<Integer> myList = Arrays.asList(10,15,8,49,25,98,98,32,15);
        int max =  myList.stream()
                .max(Integer::compare) // we use Integer::compare instead of max((a,b) -> a-b), because it is safe version and avoid overflow problem
                .get();
        System.out.println(max);

        /* or we can try using below way */
        /* When numbers are given as Array */
        int[] arr = {10,15,8,49,25,98,98,32,15};

        int maxData = Arrays.stream(arr).boxed()
                .max(Comparator.naturalOrder()).get();

        System.out.println(maxData);
    }

    private static void firstRepeatedCharacter() {

        String input = "Vishal kaushik is learning Java";

        Character result =  input.chars() // returns an IntStream(ASCII code)
                .mapToObj(c -> (char) c) // convert each int to a character
                .collect(Collectors.groupingBy(
                        Function.identity(), // group by the character itself like 's' character group
                        LinkedHashMap::new, // preserve insertion order
                        Collectors.counting() // Counts how many times each character appears
                ))
                .entrySet().stream() // Converts the map into a stream of entries
                .filter(e -> e.getValue() == 1) // Keeps only characters that appear exactly once
                .map(entry -> entry.getKey()) // Extracts the character from each entry
                .findFirst() // Returns the first element of the stream
                .orElse(null);

        System.out.println("First repeated character is : " + result);

    }

    private static void sortValues () {

        System.out.println("Sorting in increasing order");
        List<Integer> ls = Arrays.asList(10,15,8,49,25,98,98,32,15);

        ls.stream().sorted().forEach(System.out::println);

        System.out.println("Sorting in increasing order");
        ls.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
    }

    private static void containsDuplicate() {

        int [] nums = {1,2,3,4};
        Set<Integer> set = new HashSet<>();
        boolean contains = Arrays.stream(nums).anyMatch(num -> !set.add(num));
        System.out.println("Contains duplicate is : " + contains);
    }

    private static void javaTimeFunction() {
        System.out.println("Current Local Date: " + java.time.LocalDate.now());
        //Used LocalDate API to get the date
        System.out.println("Current Local Time: " + java.time.LocalTime.now());
        //Used LocalTime API to get the time
        System.out.println("Current Local Date and Time: " + java.time.LocalDateTime.now());
        //Used LocalDateTime API to get both date and time
    }

    private static void concatenateStrings() {

        List<String> list1 = Arrays.asList("Java", "8");
        List<String> list2 = Arrays.asList("explained", "through", "programs");

        Stream<String> concatStream = Stream.concat(list1.stream(), list2.stream()); // Concatenated the list1 and list2 by converting them into Stream
        concatStream.forEach(str -> System.out.print(str + " "));

        // Printed the Concatenated Stream
    }

    private static void cubeElements() {
        // perform cube on list elements and filter numbers greater than 50.

        List<Integer> integerList = Arrays.asList(4,5,6,7,1,2,3);

        integerList.stream().map(i -> i*i*i).filter(i -> i>50).forEach(System.out::println);
    }

    private static void toUpperCaseElement() {
         String [] names = {"aa", "bb", "cc", "ee"};
        Arrays.stream(names).map(String::toUpperCase).forEach(System.out::println);
    }

    private static void objectListMap() {

//        convert a List of objects into a Map by considering duplicated keys and store them in sorted order

        class Employee {
            private int deptId;
            private String name;
            private int salary;

            public Employee(int id, String empName, int sal) {
                this.deptId = id;
                this.name = empName;
                this.salary = sal;
            }

            public int getDeptId() {
                return deptId;
            }

            public int getSalary() {
                return salary;
            }

            @Override
            public String toString() {
                return name + "(" + salary + ")";
            }
        }

        List<Employee> employees = List.of(
                new Employee(1, "Alice", 50000),
                new Employee(2, "Bob", 60000),
                new Employee(1, "Charlie", 55000),
                new Employee(2, "David", 58000),
                new Employee(3, "Eve", 70000)
        );

        Map<Integer,Set<Employee>> mapEmployees = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDeptId,
                        TreeMap::new,
                        Collectors.toCollection(() ->
                                new TreeSet<>(Comparator.comparing(Employee::getSalary))
                                )
                ));

        mapEmployees.forEach((dept, empSet) ->
                System.out.println(dept + " -> " + empSet)
        );
    }

    private static void countStringFromList() {

        //count each element/word from the String ArrayList in Java8
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");
        Map<String,Long> namesCount = names.stream().collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(namesCount);

    }

    private static void duplicateElementsFromStringList() {
//        find only duplicate elements with its count from the String ArrayList in Java8
        List<String> names = Arrays.asList("AA", "BB", "AA", "CC");

        Map<String,Long> result = names.stream()
                .filter((item) -> Collections.frequency(names, item) > 1)
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        System.out.println(result);
    }

    private static void countCharacterInString() {
//        program to print the count of each character in a String
        String s = "string data to count each character";
        Map<String,Long> map = Arrays.stream(s.split(""))
                .map(String::toLowerCase)
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()));
        System.out.println(map);
    }

    public static void main(String[] args) {
//        printOddNumbersFromList();
//        printNumberStartingWithOne();
//        printDuplicatesNumber();
//        printUniquesNumber();
//        getDataWithoutDuplicates();
//        findFirstElement();
//        findTotalNumberOfElements();
//        findMaxElement();
//        firstRepeatedCharacter();
//        sortValues();
//        containsDuplicate();
//        javaTimeFunction();
//        concatenateStrings();
//        cubeElements();
//        toUpperCaseElement();
//        objectListMap();
//        countStringFromList();
//        duplicateElementsFromStringList();
//        countCharacterInString();
    }

}

