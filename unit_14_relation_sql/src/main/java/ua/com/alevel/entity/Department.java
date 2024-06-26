package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.annotations.Table;

@Getter
@Setter
@Table(name = "departments")
public class Department extends BaseEntity {

    private String name;
}
