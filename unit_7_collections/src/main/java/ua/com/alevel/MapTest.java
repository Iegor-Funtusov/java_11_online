package ua.com.alevel;

import java.io.File;
import java.util.*;

public class MapTest {

    Map<String, Set<File>> map = new HashMap<>();

    Map<Student, Integer> hashMap = new HashMap<>();
    Map<Student, Integer> linkedHashMap = new LinkedHashMap<>();
    Map<Student, Integer> treeMap = new TreeMap<>();

    Set<Student> hashSet = new HashSet<>();
    Set<Student> linkedHashSet = new LinkedHashSet<>();
    Set<Student> treeSet = new TreeSet<>();

    // set.add(1) => map.put(1, null);


//    Map<Student, Integer> treeMap1 = new TreeMap<>(new Comparator<Student>() {
//        @Override
//        public int compare(Student o1, Student o2) {
//            int compareById = Integer.compare(o1.getId(), o2.getId());
//            if (compareById != 0) {
//                return compareById;
//            }
//            return o1.getName().compareTo(o2.getName());
//        }
//    });
//  Map<Student, Integer> treeMap = new TreeMap<>(Comparator.comparingInt(Student::getId).thenComparing(Student::getName));

    public void test() {
        add();
    }

    private void add() {
        treeMap.put(new Student(1, "Ivan"), 90);
        treeMap.put(new Student(1, "Ivan1"), 90);
        treeMap.put(new Student(3, "Ivan"), 90);
        treeMap.put(new Student(2, "Ivan"), 2);

        treeMap.forEach((k, v) -> {
            System.out.println("k = " + k);
            System.out.println("v = " + v);
        });


        // 1. index = (h = key.hashCode()) ^ (h >>> 16)

//        hashMap.put(new Student(1, "Ivan"), 90);
//        hashMap.put(new Student(2, "Ivan"), 2);
//        hashMap.put(new Student(4, "Ivan"), 2);
//        hashMap.put(new Student(3, "Ivan"), 3);
//        hashMap.put(new Student(3, "Ivan"), 4);
//        hashMap.put(new Student(5, "Ivan"), 4);
//
//        System.out.println("hashMap = " + hashMap.size());
//
//        int a = hashMap.get(new Student(1, "Ivan"));
//        System.out.println("a = " + a);
//
//        System.out.println("Before remove");
//        hashMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });
//
//        hashMap.remove(new Student(1, "Ivan"));
//
//        System.out.println("After remove");
//        hashMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });
//
//        linkedHashMap.put(new Student(1, "Ivan"), 1);
//        linkedHashMap.put(new Student(2, "Ivan"), 2);
//        linkedHashMap.put(new Student(4, "Ivan"), 2);
//        linkedHashMap.put(new Student(3, "Ivan"), 3);
//        linkedHashMap.put(new Student(3, "Ivan"), 4);
//        linkedHashMap.put(new Student(5, "Ivan"), 4);
//
//        System.out.println("************************");
//        linkedHashMap.forEach((k, v) -> {
//            System.out.println("k = " + k);
//            System.out.println("v = " + v);
//        });
    }
}
