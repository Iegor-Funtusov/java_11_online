package ua.com.alevel.service;

import ua.com.alevel.dto.StudentDto;

import java.util.Collection;
import java.util.Optional;

public interface StudentService {

    void create(String firstName, String lastName, int age);
    void update(String firstName, String lastName, int age, String id);
    void delete(String id);
    Optional<StudentDto> findById(String id);
    Collection<StudentDto> findAll();
}
