package ua.com.alevel.demo_crud.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.demo_crud.entity.Student;
import ua.com.alevel.demo_crud.repository.StudentRepository;
import ua.com.alevel.demo_crud.service.StudentService;

import java.util.Collection;

@Service
@AllArgsConstructor
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Override
    public void create(Student entity) {
        studentRepository.save(entity);
    }

    @Override
    public void update(Student entity) {
        studentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        studentRepository.deleteById(id);
    }

    @Override
    public Student findById(Long id) {
        return studentRepository.findById(id).get();
    }

    @Override
    public Collection<Student> findAll() {
        return studentRepository.findAll();
    }
}
