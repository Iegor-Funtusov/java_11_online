package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dto.StudentDto;
import ua.com.alevel.dto.StudentOrder;
import ua.com.alevel.entity.Student;

public class StudentService {

    private StudentDao studentDao = new StudentDao();

    public void createStudent(StudentOrder studentOrder) {
        Student student = new Student();
        student.setFirstName(studentOrder.getFirstName());
        student.setLastName(studentOrder.getLastName());
        student.setAge(studentOrder.getAge());
        studentDao.createStudent(student);
    }

    public void updateStudent(StudentOrder studentOrder, int id) {
        Student student = studentDao.getStudentById(id);
        if (student != null) {
            student.setFirstName(studentOrder.getFirstName());
            student.setLastName(studentOrder.getLastName());
            student.setAge(studentOrder.getAge());
            studentDao.updateStudent(student);
        }
    }

    public void deleteStudent(int id) {
        studentDao.deleteStudent(id);
    }

    public StudentDto[] getAllStudents() {
        Student[] students = studentDao.getAllStudents();
        StudentDto[] studentDtos = new StudentDto[students.length];
        for (int i = 0; i < students.length; i++) {
            studentDtos[i] = convertStudentToStudentDto(students[i]);
        }
        return studentDtos;
    }

    private StudentDto convertStudentToStudentDto(Student student) {
        StudentDto studentDto = new StudentDto();
        studentDto.setId(student.getId());
        studentDto.setFullName(student.getFirstName() + " " + student.getLastName());
        studentDto.setAge(student.getAge());
        return studentDto;
    }
}
