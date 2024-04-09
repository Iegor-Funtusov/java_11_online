package ua.com.alevel;

import ua.com.alevel.entity.BaseEntity;
import ua.com.alevel.entity.Student;
import ua.com.alevel.view.StudentView;

import java.io.IOException;

public class StartOopMain {
    public static void main(String[] args) throws IOException {
        StudentView view = new StudentView();
        view.start();
//        BaseEntity baseEntity = new BaseEntity();
//        Student student = new Student();
//        Student student2 = (Student) new BaseEntity();

        // bmw - car
        // bmw is car
        // car is not bmw

        // student - base_entity
        // student is base_entity
        // base_entity is not student
    }
}
