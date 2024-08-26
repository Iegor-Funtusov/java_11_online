package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.dto.req.UserReqDto;
import ua.com.alevel.dto.res.UserResDto;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.persistence.entity.user.RoleUser;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.service.UserService;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;

    @Override
    public UserResDto createUser(UserReqDto dto) {
        User user = new User();
        user.setRole(RoleUser.ROLE_USER);
        user.setEmail(dto.getEmail());
        user.setPassword(dto.getPassword());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());

        userService.create(user);

        user = userService.findByEmail(dto.getEmail());

        return new UserResDto(user);
    }

    @Override
    public UserResDto findById(Long id) {
        return new UserResDto(userService.findById(id));
    }
}
