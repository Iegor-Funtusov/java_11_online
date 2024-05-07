package ua.com.alevel;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamTest {

    private void parallel() {
        List<Integer> integers = IntStream.range(1, 10_000_000).boxed().toList();

        long sum = 0;
        long start;
        long end;
        // classic
        start = System.currentTimeMillis();
        sum = integers.stream().reduce(0, (a, b) -> a + b);
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum);
        System.out.println("end classic: " + end);
        // think and parallel
        start = System.currentTimeMillis();
        sum = integers.stream().parallel().reduce(0, (a, b) -> a + b);
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum);
        System.out.println("end think and parallel: " + end);
        // parallel
        start = System.currentTimeMillis();
        sum = integers.parallelStream().reduce(0, (a, b) -> a + b);
        end = System.currentTimeMillis() - start;
        System.out.println("sum = " + sum);
        System.out.println("end parallel: " + end);
    }

    private void bool() {
        List<String> strings = Arrays.asList("1", "2", "3", "y");
        boolean isAnyContainsInt = strings.stream()
                .anyMatch(str -> str.matches("[0-9]"));
        boolean isAllContainsInt = strings.stream()
                .allMatch(str -> str.matches("[0-9]"));
        boolean isNotContainsInt = strings.stream()
                .noneMatch(str -> str.matches("[0-9]"));
        System.out.println("isAnyContainsInt = " + isAnyContainsInt);
        System.out.println("isAllContainsInt = " + isAllContainsInt);
        System.out.println("isNotContainsInt = " + isNotContainsInt);
    }

    private void sum() {
        List<String> strings = Arrays.asList("on4e", "t56wo", "7three");
        int sum = strings.stream()
                .map(s -> s.replaceAll("[a-zA-Z]", ""))
                .map(s -> Integer.valueOf(s))
                // 1 convert to IntStream
//                .mapToInt(i -> i)
//                .sum();
                // 2 collectors
//                        .collect(Collectors.summingInt(i -> i));
        // 3 reduce
        .reduce(10, (a, b) -> a + b);
        System.out.println("sum = " + sum);
    }

    private void joinStream() {
        String hello = "Hello World";
        List<Integer> integers = hello
                .chars()
//                .mapToObj(i -> (char) i)
//                .map(c -> (int) c)
                .boxed()
                .toList();
        System.out.println("integers = " + integers);
    }

    public void exam() {
//        joinStream();
//        sum();
//        bool();
        parallel();

        // Create stream
        // 1
//        List<String> list = Arrays.asList("g", "c", "a", "b", "a", "c", "d", "e", "f", "g", "h");
//        System.out.println("list = " + list);
//        Stream<String> stream1 = list.stream();
//        // 2
//        Stream<String> stream2 = Stream.of("a", "b", "c", "d", "e", "f", "g", "h");
//        // 3
//        String[] strings = new String[]{"a", "b", "c", "d", "e", "f", "g", "h"};
//        Stream<String> stream3 = Stream.of(strings);
//
//        // Operators
//        Stream<String> stream4 = stream1
//                .distinct()
//                .filter(s -> !s.equals("a"))
////                .peek(s -> System.out.println("s = " + s))
//                .limit(4)
//                .skip(1)
//                .sorted()
//                .map(s -> s.toUpperCase());
//
//        List<String> list2 = stream4.toList();
//        System.out.println("list2 = " + list2);
    }

    public void test() {
        // 1 - sort
        // 2 - even
        // 3 - unique
        // 4 - multi * 2
        List<Integer> integers = Arrays.asList(3,6,8,2,90,8,5,46);
        TreeSet<Integer> treeSet = new TreeSet<>(integers);
        StringBuilder stringBuilder = new StringBuilder();
        for (Integer i : treeSet) {
            if (i % 2 == 0) {
                stringBuilder.append(i * 2);
            }
        }
        Long res = Long.parseLong(stringBuilder.toString());
        System.out.println("res = " + res);

        // 1 - conveyor -> input stream - output stream
        // 2 - terminal -> input stream - output object

        String result = integers
                .stream()
                .distinct()
                .sorted()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .map(i -> String.valueOf(i))
                .collect(Collectors.joining());

        System.out.println("result = " + result);

        int sum = integers
                .stream()
                .distinct()
                .sorted()
                .filter(i -> i % 2 == 0)
                .map(i -> i * 2)
                .peek(i -> System.out.println(i))
                .mapToInt(i -> i)
                .sum();
        System.out.println("sum = " + sum);


        List<String> strings = integers.stream().map(i -> String.valueOf(i)).toList();
        System.out.println("strings = " + strings);
    }
}
