package ua.com.alevel.dto.res;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ua.com.alevel.persistence.entity.user.User;

@Getter
@Setter
@NoArgsConstructor
public class UserResDto extends ResDto {

    private String email;
    private String firstName;
    private String lastName;

    public UserResDto(User user) {
        setId(user.getId());
        this.email = user.getEmail();
        this.firstName = user.getFirstName();
        this.lastName = user.getLastName();
    }
}
