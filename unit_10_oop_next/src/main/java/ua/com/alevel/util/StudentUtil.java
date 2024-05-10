package ua.com.alevel.util;

import ua.com.alevel.dto.StudentDto;
import ua.com.alevel.entity.Student;

import java.util.Collection;
import java.util.UUID;

public final class StudentUtil {

    private StudentUtil() {}

    public static String generateId(Collection<Student> students) {
        String id = UUID.randomUUID().toString();
        if (students.stream().anyMatch(student -> student.getId().equals(id))) {
            return generateId(students);
        }
        return id;
    }

    public static StudentDto generateDtoByEntity(Student student) {
        return new StudentDto(
                student.getId(), student.getFirstName() + " " + student.getLastName(),
                student.getAge());
    }
}
