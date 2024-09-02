package ua.com.alevel.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.dto.req.UserReqDto;
import ua.com.alevel.dto.res.TokenResDto;
import ua.com.alevel.dto.res.UserResDto;
import ua.com.alevel.facade.UserFacade;
import ua.com.alevel.persistence.entity.user.RoleUser;
import ua.com.alevel.persistence.entity.user.Token;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.service.AuthService;
import ua.com.alevel.service.UserService;

@Service
@AllArgsConstructor
public class UserFacadeImpl implements UserFacade {

    private final UserService userService;
    private final AuthService authService;

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

    @Override
    public TokenResDto login(UserReqDto dto) {
        User user = userService.findByEmail(dto.getEmail());
        Token token = authService.login(user);
        return new TokenResDto(token.getToken(), token.getExpiryDate());
    }
}
