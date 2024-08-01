package ua.com.alevel.dto.res;

import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.entity.Employee;

import java.util.Date;

@Getter
@Setter
public class EmployeeResDto extends BaseResDto {

    private String firstName;
    private String lastName;
    private Date birthDay;
    private int age;

    public EmployeeResDto(Employee employee) {
        setId(employee.getId());
        setCreated(employee.getCreated());
        setUpdated(employee.getUpdated());
        setFirstName(employee.getFirstName());
        setLastName(employee.getLastName());
        setBirthDay(employee.getBirthDay());
        setAge(employee.getAge());
    }
}
