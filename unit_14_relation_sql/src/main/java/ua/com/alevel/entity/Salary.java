package ua.com.alevel.entity;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.annotations.Table;

@Getter
@Setter
@Table
public class Salary extends BaseEntity {

    private Long salary;
}
