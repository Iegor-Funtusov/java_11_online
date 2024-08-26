package ua.com.alevel.integration.controller;

import com.google.gson.Gson;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import ua.com.alevel.dto.req.UserReqDto;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static ua.com.alevel.util.TestUtil.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Order(1)
    public void shouldBeCreateUserWhereUserNotExists() throws Exception {
        //given
        final String userJson = generateUserReqJson();

        // when
        ResultActions resultActions = mockMvc.perform(
                post("/api/users/register")
                .contentType(MediaType.APPLICATION_JSON)
                .content(userJson)
        );

        // then
        resultActions
                .andExpect(status().isCreated())
                .andExpect(content().json(generateUserResJson()));
    }

    @Test
    @Order(2)
    public void shouldBeCreateUserWhereEmailExists() throws Exception {
        //given
        final String userJson = generateUserReqJson();

        // when
        ResultActions resultActions = mockMvc.perform(
                post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
        );

        // then
        resultActions
                .andExpect(status().isUnprocessableEntity());
    }

    @Test
    @Order(3)
    public void shouldBeCreateUserWhereEmailIsNotExists() throws Exception {
        //given
        UserReqDto dto = new UserReqDto();
        dto.setFirstName(FIRST_NAME);
        dto.setLastName(LAST_NAME);
        dto.setPassword(TEST_PASSWORD);
        final String userJson = new Gson().toJson(dto);

        // when
        ResultActions resultActions = mockMvc.perform(
                post("/api/users/register")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(userJson)
        );

        // then
        resultActions
                .andExpect(status().isBadRequest());
    }
}
