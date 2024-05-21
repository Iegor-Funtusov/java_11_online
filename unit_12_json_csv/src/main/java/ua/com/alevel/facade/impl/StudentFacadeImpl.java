package ua.com.alevel.facade.impl;

import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.dao.impl.StudentDaoImpl;
import ua.com.alevel.dto.StudentDto;
import ua.com.alevel.entity.Student;
import ua.com.alevel.facade.StudentFacade;

import java.util.Collection;

public class StudentFacadeImpl implements StudentFacade {

    private final StudentDao studentDao = new StudentDaoImpl();

    @Override
    public Collection<StudentDto> getAllStudents() {
        Collection<Student> students = studentDao.findAll();
        return students.stream().map(student -> new StudentDto(
                student.getId(),
                student.getFirstName() + " " + student.getLastName(),
                student.getAge()
        )).toList();
    }
}
