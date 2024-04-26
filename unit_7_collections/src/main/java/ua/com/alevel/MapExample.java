package ua.com.alevel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapExample {

    private Map<String, List<Apple>> apppleMap = new HashMap<>();

    public void add(Apple apple, String sort) {
        List<Apple> list = apppleMap.get(sort);
        if (list == null) {
            list = new ArrayList<>();
        }
        list.add(apple);
        apppleMap.put(sort, list);
    }

    public void print() {
        apppleMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            v.forEach(System.out::println);
        });
    }

    public static class Apple {
        private String name;

        public Apple(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "Apple{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
