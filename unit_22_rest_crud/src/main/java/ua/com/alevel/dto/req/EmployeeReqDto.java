package ua.com.alevel.dto.req;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class EmployeeReqDto extends BaseReqDto {

    private String firstName;
    private String lastName;
    private Date birthDay;
}
