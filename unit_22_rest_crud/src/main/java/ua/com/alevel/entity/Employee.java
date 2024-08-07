package ua.com.alevel.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import ua.com.alevel.listener.EmployeeAgeGeneratorByBirthDayListener;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@ToString(callSuper = true)
@Table(name = "employees")
@EntityListeners({
        EmployeeAgeGeneratorByBirthDayListener.class
})
public class Employee extends BaseEntity {

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Temporal(TemporalType.TIMESTAMP)
    private Date birthDay;

    @Transient
    private int age;

    @ManyToMany(mappedBy = "employees")
    @ToString.Exclude
    private Set<Department> departments;

    public Employee() {
        this.departments = new HashSet<>();
    }
}
