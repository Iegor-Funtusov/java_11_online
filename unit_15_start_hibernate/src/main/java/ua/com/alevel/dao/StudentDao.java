package ua.com.alevel.dao;

import ua.com.alevel.entity.Student;

import java.util.Collection;
import java.util.Optional;

public interface StudentDao {

    void createStudent(Student student);
    void updateStudent(Student student);
    void deleteStudent(Long id);
    long count();
    Optional<Student> getStudentById(Long id);
    Collection<Student> getAllStudents();
}
