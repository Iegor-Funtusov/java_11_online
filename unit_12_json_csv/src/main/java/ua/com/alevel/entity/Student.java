package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
public class Student extends BaseEntity implements Serializable {

    private String firstName;
    private String lastName;
    private transient String fullName;
    private Integer age;
}
