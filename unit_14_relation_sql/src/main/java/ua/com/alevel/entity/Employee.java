package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString(callSuper = true)
public class Employee extends BaseEntity {
    private String firstName;
    private String lastName;
    private int age;
}
