package ua.com.alevel.dto.req;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserReqDto {

    @Email
    private String email;
    private String password;
    private String firstName;
    private String lastName;

    @NotBlank(message = "User name can not be empty")
    private String username;
}
