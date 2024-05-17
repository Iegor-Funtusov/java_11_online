package ua.com.alevel.dao.impl;

import ua.com.alevel.bd.BDStorage;
import ua.com.alevel.dao.StudentDao;
import ua.com.alevel.entity.Student;
import ua.com.alevel.factory.DBFactory;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class StudentDaoImpl implements StudentDao {

    private final BDStorage bdStorage = DBFactory.getInstance().getBdStorage();

    @Override
    public void create(Student entity) {
        bdStorage.createStudent(entity);
    }

    @Override
    public void update(Student entity) {

    }

    @Override
    public void delete(String id) {

    }

    @Override
    public Optional<Student> findById(String id) {
        return bdStorage.findStudentById(id);
    }

    @Override
    public Collection<Student> findAll() {
        return bdStorage.findAllStudents();
    }
}
