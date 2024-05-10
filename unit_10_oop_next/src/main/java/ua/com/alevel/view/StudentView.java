package ua.com.alevel.view;

import ua.com.alevel.dto.StudentDto;
import ua.com.alevel.entity.Student;
import ua.com.alevel.service.StudentService;
import ua.com.alevel.service.StudentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Collection;
import java.util.Optional;

public class StudentView {

    private StudentService studentService = new StudentServiceImpl();

    public void start() {
        System.out.println("Welcome to student view!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        menu();
        try {
            while ((text = reader.readLine()) != null) {
                goToOperations(text, reader);
                menu();
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
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
            case "3" -> getStudentById(reader);
            case "4" -> updateStudent(reader);
            case "5" -> deleteStudent(reader);
            case "6" -> System.exit(0);
        }
    }

    private void getStudentById(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student");
        String id = reader.readLine();
        Optional<StudentDto> studentDto = studentService.findById(id);
        if (studentDto.isPresent()) {
            System.out.println(studentDto.get());
        } else {
            System.out.println("Student not found");
        }
    }

    private void createStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the first name of the student");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name of the student");
        String lastName = reader.readLine();
        System.out.println("Please enter the age of the student");
        int age = Integer.parseInt(reader.readLine());

        studentService.create(firstName, lastName, age);
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

        studentService.update(firstName, lastName, age, id);
    }

    private void deleteStudent(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the student you would like to delete");
        String id = reader.readLine();
        studentService.delete(id);
    }

    private void getStudents() {
        Collection<StudentDto> studentDtoCollection = studentService.findAll();
        for (StudentDto studentDto : studentDtoCollection) {
            System.out.println("studentDto = " + studentDto);
        }
    }
}
