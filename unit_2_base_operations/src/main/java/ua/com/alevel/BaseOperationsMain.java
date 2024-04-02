package ua.com.alevel;

import java.io.IOException;

public class BaseOperationsMain {
    public static void main(String[] args) throws IOException {
        ConsoleExam exam = new ConsoleExam();
        exam.test();

//        int a = 10;
//        int b = a;
//        System.out.println("b = " + b);
//        b = 11;
//        System.out.println("a = " + a);
////        int res = sum(10, 7);
////        blaBla(sum(10, 7));
////        Student student1 = { name: 'Iehor', age: 38 };
//        Student student1 = new Student();
//        student1.name = "Iehor";
//        student1.age = 38;
//        System.out.println("name: " + student1.name);
//        System.out.println("age: " + student1.age);
//
//        Student student2 = student1;
//        System.out.println("name: " + student2.name);
//        System.out.println("age: " + student2.age);
//        student2.age = 39;
//        student2.name = "Yaroslav";
//
//        System.out.println("age: " + student1.age);
//        System.out.println("student1 = " + student1.name);
    }

    public static int sum(int a, int b) {
        int res = a + b;
        return res;
    }

    public static void blaBla(int a) {
        System.out.println("a = " + a);
    }
}
