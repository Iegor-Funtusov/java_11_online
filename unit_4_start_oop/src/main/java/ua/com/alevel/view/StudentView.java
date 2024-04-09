package ua.com.alevel.view;

import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class StudentView {

    private StudentService studentService = new StudentService();

    public void start() throws IOException {
        System.out.println("Welcome to student view!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        menu();
        while ((text = reader.readLine()) != null) {
            goToOperations(text, reader);
            menu();
        }
    }

    private void menu() {
        System.out.println("If you want create student please enter 1");
        System.out.println("If you want find all student please enter 2");
        System.out.println("If you want update student please enter 3");
        System.out.println("If you want delete student please enter 4");
        System.out.println("If you want exit please enter 5");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> createStudent(reader);
            case "2" -> getStudents();
            case "3" -> updateStudent(reader);
            case "4" -> deleteStudent(reader);
            case "5" -> System.exit(0);
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

        studentService.createStudent(student);
    }

    private void updateStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student");
        int id = Integer.parseInt(reader.readLine());
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
        studentService.deleteStudent(Integer.parseInt(id));
    }

    private void getStudents() {
        Student[] students = studentService.getStudents();
        for (int i = 0; i < students.length; i++) {
            if (students[i] != null) {
                System.out.println("#: " + i);
                System.out.println("Id " + students[i].getId());
                System.out.println("First name " + students[i].getFirstName());
                System.out.println("Last name " + students[i].getLastName());
                System.out.println("Age " + students[i].getAge());
            }
        }
    }
}
