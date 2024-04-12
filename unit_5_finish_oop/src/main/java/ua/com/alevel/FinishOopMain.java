package ua.com.alevel;

import ua.com.alevel.entity.Student;
import ua.com.alevel.view.StudentView;

import java.io.IOException;

public class FinishOopMain {
    public static void main(String[] args) throws IOException {
//        new StudentView().start();


        final int a = 0;
//        a = 10;
        System.out.println("a = " + a);

        final Student student = new Student();
        student.setFirstName("Alex");
        System.out.println("student = " + student);

        Student student2 = new Student();
        student2 = student;
        student2.setFirstName("Bob");
        System.out.println("student = " + student);

//        const int a = 10;
        final double PI = 3.14;
//        System.out.println("PI = " + PI);
//
//        Student student;
//        System.out.println("student = " + student);



        new Student();

//        Student student = new Student();
//        student.setFirstName("Alex");
//        student.setLastName("Kumar");
//        student.setAge(10);
//
//        Student student2 = new Student();
//        student2.setFirstName("Bob");
//        student2.setLastName("Kumar");
//        student2.setAge(20);
//
//        student2 = student;




//        goto
    }
}
