package ua.com.alevel.util;

import com.google.gson.Gson;
import ua.com.alevel.dto.req.UserReqDto;
import ua.com.alevel.dto.res.UserResDto;

public class TestUtil {

    public static final Long ID = 1L;
    public static final String TEST_EMAIL = "test@email.com";
    public static final String TEST_PASSWORD = "password";
    public static final String FIRST_NAME = "Name1";
    public static final String LAST_NAME = "Name2";
    public static final String USER_NAME = "username";

    private TestUtil() {}

    public static String generateUserReqJson() {
        UserReqDto dto = new UserReqDto();
        dto.setFirstName(FIRST_NAME);
        dto.setLastName(LAST_NAME);
        dto.setEmail(TEST_EMAIL);
        dto.setPassword(TEST_PASSWORD);
        dto.setUsername(USER_NAME);
        return new Gson().toJson(dto);
    }

    public static String generateUserResJson() {
        UserResDto dto = new UserResDto();
        dto.setId(ID);
        dto.setFirstName(FIRST_NAME);
        dto.setLastName(LAST_NAME);
        dto.setEmail(TEST_EMAIL);
        return new Gson().toJson(dto);
    }
}
