package ua.com.alevel;

import java.util.*;
import java.util.stream.Collectors;

public class StreamTest {

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
