package ua.com.alevel;

import java.util.*;

public class ListTest {

    private final List<Integer> arrayList = new ArrayList<>();
    private final List<Integer> linkedList = new LinkedList<>();
    private final static int SIZE = 100_000;

    public void test() {
        add();
//        get();
//        update();
        delete();
    }

    private void add() {
        System.out.println("Start add arrayList");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.add(i); // O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Start finish arrayList: " + end);

        System.out.println("Start add linkedList");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.add(i); // O(1)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("Start finish linkedList: " + end);
    }

    private void get() {
        System.out.println("Start get arrayList");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.get(i); // O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Start finish arrayList: " + end);

        System.out.println("Start get linkedList");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.get(i); // O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("Start finish linkedList: " + end);
    }

    private void update() {
        System.out.println("Start set arrayList");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            arrayList.set(i, i); // O(1)
        }
        long end = System.currentTimeMillis() - start;
        System.out.println("Start finish arrayList: " + end);

        System.out.println("Start set linkedList");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            linkedList.set(i, i); // O(n)
        }
        end = System.currentTimeMillis() - start;
        System.out.println("Start finish linkedList: " + end);
    }

    private void delete() {
        System.out.println("Start delete arrayList");
        long start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            if (arrayList.get(0) != null) {
                arrayList.remove(0);
            }
        }
//        for (int i = 0; i < SIZE; i++) {
//            arrayList.remove(i); // O(1)
//        }
//        arrayList.clear();
//        arrayList.size();
        long end = System.currentTimeMillis() - start;
        System.out.println("Start finish arrayList: " + end);

        System.out.println("Start delete linkedList");
        start = System.currentTimeMillis();
        for (int i = 0; i < SIZE; i++) {
            if (linkedList.get(0) != null) {
                linkedList.remove(0);
            }
        }
//        for (int i = 0; i < SIZE; i++) {
//            linkedList.remove(i); // O(n)
//        }
        end = System.currentTimeMillis() - start;
        System.out.println("Start finish linkedList: " + end);
    }
}
