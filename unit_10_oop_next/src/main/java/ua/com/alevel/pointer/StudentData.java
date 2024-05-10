package ua.com.alevel.pointer;

import lombok.Data;
import ua.com.alevel.entity.Student;

@Data
public class StudentData {

    private String id;
    private String firstName;
    private String lastName;
    private int age;

    public StudentData() {}

    public StudentData(String id, String firstName, String lastName, int age) {}

    public StudentData(Student student) {
        this.id = student.getId();
        this.firstName = student.getFirstName();
        this.lastName = student.getLastName();
        this.age = student.getAge();
    }
}
