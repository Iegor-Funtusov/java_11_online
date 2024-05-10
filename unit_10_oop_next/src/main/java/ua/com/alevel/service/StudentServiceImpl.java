package ua.com.alevel.service;

import ua.com.alevel.db.ListStudentDao;
import ua.com.alevel.db.StudentDao;
import ua.com.alevel.dto.StudentDto;
import ua.com.alevel.entity.Student;
import ua.com.alevel.util.StudentUtil;

import java.util.Collection;
import java.util.Optional;

public class StudentServiceImpl implements StudentService {

    private final StudentDao studentDao = new ListStudentDao();

    @Override
    public void create(String firstName, String lastName, int age) {
        Student student = new Student(firstName, lastName, age);
        studentDao.create(student);
    }

    @Override
    public void update(String firstName, String lastName, int age, String id) {
        Student student = new Student(firstName, lastName, age);
        student.setId(id);
        studentDao.update(student);
    }

    @Override
    public void delete(String id) {
        studentDao.deleteById(id);
    }

    @Override
    public Optional<StudentDto> findById(String id) {
        Optional<Student> student = studentDao.findById(id);
        if (student.isPresent()) {
            Student entity = student.get();
            return Optional.of(StudentUtil.generateDtoByEntity(entity));
        }
        return Optional.empty();
    }

    @Override
    public Collection<StudentDto> findAll() {
        return studentDao.findAll()
                .stream()
//                .map(student -> StudentUtil.generateDtoByEntity(student))
                .map(StudentUtil::generateDtoByEntity)
                .toList();
    }
}
