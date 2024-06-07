package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.annotations.Table;

@Getter
@Setter
@ToString(callSuper = true)
@Table(name = "employees")
public class Employee extends BaseEntity {

    private String firstName;
    private String lastName;
    private Integer age;
}
