package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Student extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer age;
}
