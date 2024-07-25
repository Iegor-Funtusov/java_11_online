package ua.com.alevel.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class EmployeeDto {

    private Long id;
    private String firstName;
    private String lastName;
    private String birthDay;
}
