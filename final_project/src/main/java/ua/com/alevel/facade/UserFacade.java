package ua.com.alevel.facade;

import ua.com.alevel.dto.req.UserReqDto;
import ua.com.alevel.dto.res.UserResDto;

public interface UserFacade {

    UserResDto createUser(UserReqDto dto);

    UserResDto findById(Long id);
}
