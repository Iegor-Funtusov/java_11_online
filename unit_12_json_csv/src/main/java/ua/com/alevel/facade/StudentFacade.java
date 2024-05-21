package ua.com.alevel.facade;

import ua.com.alevel.dto.StudentDto;

import java.util.Collection;

public interface StudentFacade {

    Collection<StudentDto> getAllStudents();
}
