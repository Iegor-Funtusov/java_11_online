package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;

class ConsoleExam {

    void test() throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        mathExam(reader);
//        initStudent(reader);
//        System.out.println("Hello, please enter first value");
//        String text1 = reader.readLine();
//        System.out.println("Please enter second value");
//        String text2 = reader.readLine();
//
//        int a = Integer.parseInt(text1);
//        int b = Integer.parseInt(text2);
//        sum(a, b);
    }

    void sum(int a, int b) {
        System.out.println("sum: " + (a + b));
    }

    void initStudent(BufferedReader reader) throws IOException {
        System.out.println("Hello, please enter name");
        String name = reader.readLine();
        System.out.println("Hello, please enter age");
        String ageString = reader.readLine();
        int age = Integer.parseInt(ageString);
        Student student = new Student();
        student.name = name;
        student.age = age;
        System.out.println("student name = " + student.name);
        System.out.println("student age = " + student.age);
    }

    void mathExam(BufferedReader reader) throws IOException {
        System.out.println("Hello, please enter first value");
        String s1 = reader.readLine();
        System.out.println("Hello, please enter second value");
        String s2 = reader.readLine();
        double d1 = Double.parseDouble(s1);
        double d2 = Double.parseDouble(s2);
        System.out.println(d1 - d2);

        BigDecimal bigDecimal1 = new BigDecimal(s1);
        BigDecimal bigDecimal2 = new BigDecimal(s2);
        BigDecimal res = bigDecimal1.subtract(bigDecimal2);
        System.out.println("res = " + res);
    }
}
