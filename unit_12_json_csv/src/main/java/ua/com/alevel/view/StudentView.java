package ua.com.alevel.view;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.impl.StudentDaoImpl;
import ua.com.alevel.entity.Student;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;
import java.util.Optional;

public class StudentView {

    private final StudentDao studentDao = new StudentDaoImpl();

    public void start(BufferedReader reader) throws IOException {
        System.out.println("Welcome to student view!");
        String text;
        menu();
        while ((text = reader.readLine()) != null) {
            if (text.equals("6")) {
                return;
            }
            goToOperations(text, reader);
            menu();
        }
    }

    private void menu() {
        System.out.println("If you want create student please enter 1");
        System.out.println("If you want find all student please enter 2");
        System.out.println("If you want find by id student please enter 3");
        System.out.println("If you want update student please enter 4");
        System.out.println("If you want delete student please enter 5");
        System.out.println("If you want exit please enter 6");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> createStudent(reader);
            case "2" -> getStudents();
            case "3" -> findStudent(reader);
            case "4" -> updateStudent(reader);
            case "5" -> deleteStudent(reader);
        }
    }

    private void createStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the first name of the student");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name of the student");
        String lastName = reader.readLine();
        System.out.println("Please enter the age of the student");
        int age = Integer.parseInt(reader.readLine());

        Student student = new Student();
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);

        studentDao.create(student);
    }

    private void updateStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student");
        String id = reader.readLine();
        System.out.println("Please enter the first name of the student");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name of the student");
        String lastName = reader.readLine();
        System.out.println("Please enter the age of the student");
        int age = Integer.parseInt(reader.readLine());

        Student student = new Student();
        student.setId(id);
        student.setFirstName(firstName);
        student.setLastName(lastName);
        student.setAge(age);

        studentDao.update(student);
    }

    private void findStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter id of the student");
        String id = reader.readLine();


        Optional<Student> optionalStudent = studentDao.findById(id);
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            System.out.println("Id " + student.getId());
            System.out.println("First name " + student.getFirstName());
            System.out.println("Last name " + student.getLastName());
            System.out.println("Age " + student.getAge());
        } else {
            System.out.println("Student not found by id " + id);
        }
    }

    private void deleteStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student you would like to delete");
        String id = reader.readLine();
        studentDao.delete(id);
    }

    private void getStudents() {
        Collection<Student> students = studentDao.findAll();
        for (Student student : students) {
            System.out.println("Id " + student.getId());
            System.out.println("First name " + student.getFirstName());
            System.out.println("Last name " + student.getLastName());
            System.out.println("Age " + student.getAge());
        }
    }
}
