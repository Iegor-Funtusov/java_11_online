package ua.com.alevel.service;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.StudentDaoImpl;
import ua.com.alevel.entity.Student;

import java.util.Collection;

public class StudentService {

    private final StudentDao studentDao = new StudentDaoImpl();

    public void createStudent(Student student) {
        studentDao.createStudent(student);
    }

    public void updateStudent(Student student) {
        studentDao.updateStudent(student);
    }

    public void deleteStudent(Long id) {
        studentDao.deleteStudent(id);
    }

    public Student findStudent(Long id) {
        return studentDao.getStudentById(id).orElseThrow(() -> new RuntimeException("Student not found"));
    }

    public Collection<Student> getStudents() {
        return studentDao.getAllStudents();
    }

    public Long countStudents() {
        return studentDao.count();
    }
}
