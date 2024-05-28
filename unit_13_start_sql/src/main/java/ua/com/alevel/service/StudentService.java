package ua.com.alevel.service;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;

import java.util.List;

// C - create
// R - read
// U - update
// D - delete
public class StudentService {

    private final StudentDao studentDao = new StudentDao();

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
        return studentDao.getStudentById(id);
    }

    public List<Student> getStudents() {
        return studentDao.getAllStudents();
    }
}
