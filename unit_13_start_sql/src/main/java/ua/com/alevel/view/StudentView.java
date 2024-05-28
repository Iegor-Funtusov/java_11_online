package ua.com.alevel.view;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

public class StudentView {

    private StudentService studentService = new StudentService();

    public void start() {
        System.out.println("Welcome to student view!");
        String text;
        menu();
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            while ((text = reader.readLine()) != null) {
                goToOperations(text, reader);
                menu();
            }
        } catch (IOException e) {
            System.out.println("e = " + e.getMessage());
        }
    }

    private void menu() {
        System.out.println("If you want create student please enter 1");
        System.out.println("If you want find all student please enter 2");
        System.out.println("If you want find student by id please enter 3");
        System.out.println("If you want update student please enter 4");
        System.out.println("If you want delete student please enter 5");
        System.out.println("If you want exit please enter 6");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> createStudent(reader);
            case "2" -> getStudents();
            case "3" -> getStudentById(reader);
            case "4" -> updateStudent(reader);
            case "5" -> deleteStudent(reader);
            case "6" -> System.exit(0);
        }
    }

    private void getStudentById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student");
        Long id = Long.parseLong(reader.readLine());
        Student student = studentService.findStudent(id);
        System.out.println("student = " + student);
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

        studentService.createStudent(student);
    }

    private void updateStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student");
        Long id = Long.parseLong(reader.readLine());
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

        studentService.updateStudent(student);
    }

    private void deleteStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student you would like to delete");
        String id = reader.readLine();
        studentService.deleteStudent(Long.parseLong(id));
    }

    private void getStudents() {
        List<Student> students = studentService.getStudents();
        for (Student student : students) {
            System.out.println("student = " + student);
        }
    }
}
