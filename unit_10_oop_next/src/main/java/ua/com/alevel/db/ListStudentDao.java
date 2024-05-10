package ua.com.alevel.db;

import ua.com.alevel.entity.Student;
import ua.com.alevel.util.StudentUtil;

import java.util.*;

public class ListStudentDao implements StudentDao {

    private final List<Student> students = new ArrayList<>();

    @Override
    public void create(Student entity) {
        entity.setId(StudentUtil.generateId(students));
        entity.setCreated(new Date());
        entity.setUpdated(new Date());
        students.add(entity);
    }

    @Override
    public void update(Student entity) {
        Optional<Student> optionalStudent = findById(entity.getId());
        if (optionalStudent.isPresent()) {
            Student student = optionalStudent.get();
            student.setFirstName(entity.getFirstName());
            student.setLastName(entity.getLastName());
            student.setAge(entity.getAge());
            student.setUpdated(new Date());
        }
    }

    @Override
    public void deleteById(String id) {
        students.removeIf(student -> student.getId().equals(id));
    }

    @Override
    public Optional<Student> findById(String id) {
        return students.stream().filter(student -> student.getId().equals(id)).findFirst();
    }

    @Override
    public Collection<Student> findAll() {
        return students;
    }
}
