package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ExceptionMain {

    private Throwable throwable;

    private Error error;
    private StackOverflowError stackOverflowError;
    private OutOfMemoryError outOfMemoryError;

    private Exception exception;
    private IOException ioException;
    private SQLException sqlException;
    private RuntimeException runtimeException;


    public static void main(String[] args) throws IOException {
//        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        String input = br.readLine();
//        new ExceptionTest().test(input);

//        try {
//            new ExceptionTest().createStudent();
//        } catch (Exception e) {
//            System.out.println("e = " + e);
//        }


        Student student = new Student();
        int some = student.getSomething();
        System.out.println("some = " + some);

        try {
            int a = 10 / 0;
        } finally {
            System.out.println("finally");
        }

        System.out.println("Finish");


//        try {
//            List<Integer> list = new ArrayList<>(1_000_000_000);
//            for (int i = 0; i < 1_000_000_000; i++) {
//                list.add(i);
//            }
//        } catch (OutOfMemoryError e) {
//            System.out.println("e = " + e);
//        } finally {
//            System.out.println("finally");
//        }


//        List<ExceptionThread> threads = new ArrayList<>();
//        for (int i = 0; i < 10; i++) {
//            ExceptionThread thread = new ExceptionThread("Custom thread " + i);
//            threads.add(thread);
//        }
//
//        for (ExceptionThread thread : threads) {
//            thread.start();
//        }
//
//        System.out.println("Finish");



//        List<Integer> list = new ArrayList<>(1_000_000_000);
//        for (int i = 0; i < 1_000_000_000; i++) {
//            list.add(i);
//
//            if (i % 10_000 == 0) {
//                Runtime runtime = Runtime.getRuntime();
//                long free = runtime.freeMemory();
//                System.out.println("free = " + free);
//                runtime.gc();
//            }
//        }

//        System.out.println("before");
//        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
//        String text = bf.readLine();
//        int value = Integer.parseInt(text);
//        int res = 10 / value;
//        System.out.println(res);
//        System.out.println("after");


    }
}
