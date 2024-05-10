package ua.com.alevel;

//import ua.com.alevel.dto.StudentDto;
//import ua.com.alevel.entity.Student;
//
//import java.lang.reflect.Field;

import ua.com.alevel.pointer.DateTest;
import ua.com.alevel.pointer.PointerToMethod;

public class OopNextMain {

    public static void main(String[] args) {
        new DateTest().test();
//        new PointerToMethod().test();
//        new StudentView().start();

//        StudentDto student = new StudentDto("bla", "name1", 20);
//        System.out.println("student = " + student.fullName());
//
//        Class<?> studentClass = student.getClass();
//        Field[] fields = studentClass.getDeclaredFields();
//        for (Field field : fields) {
//            try {
//                field.setAccessible(true);
//                if (field.getName().equals("fullName")) {
//                    field.set(student, "name2");
//                }
//            } catch (IllegalAccessException e) {
//                throw new RuntimeException(e);
//            }
//        }
//
//        System.out.println("student = " + student.fullName());
    }
}