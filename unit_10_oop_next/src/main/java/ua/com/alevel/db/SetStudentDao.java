package ua.com.alevel.db;

import ua.com.alevel.entity.Student;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

public class SetStudentDao implements StudentDao {
    @Override
    public void create(Student entity) {

    }

    @Override
    public void update(Student entity) {

    }

    @Override
    public void deleteById(String id) {

    }

    @Override
    public Optional<Student> findById(String id) {
        return Optional.empty();
    }

    @Override
    public Collection<Student> findAll() {
        return List.of();
    }
}
