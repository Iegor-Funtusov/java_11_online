package ua.com.alevel.integration.controller;

import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;

import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import ua.com.alevel.dto.req.UserReqDto;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.notNullValue;
import static ua.com.alevel.util.TestUtil.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class UserControllerAssuredTest {

    @LocalServerPort
    private Integer port;

    @BeforeEach
    void setUp() {
        RestAssured.port = port;
    }

    @Test
    @Order(1)
    public void shouldBeCreateUserWhereUserNotExists() {
        given()
                .contentType(ContentType.JSON)
                .body(generateUserReqJson())
        .when()
                .post("/api/users/register")
        .then()
                .statusCode(HttpStatus.CREATED.value());
    }

    @Test
    @Order(2)
    public void shouldBeCreateUserWhereEmailExists() {
        given()
                .contentType(ContentType.JSON)
                .body(generateUserReqJson())
        .when()
                .post("/api/users/register")
        .then()
                .statusCode(HttpStatus.UNPROCESSABLE_ENTITY.value());
    }

    @Test
    @Order(3)
    public void shouldBeCreateUserWhereEmailIsNotExists() {
        UserReqDto dto = new UserReqDto();
        dto.setFirstName(FIRST_NAME);
        dto.setLastName(LAST_NAME);
        dto.setPassword(TEST_PASSWORD);
        final String userJson = new Gson().toJson(dto);

        given()
                .contentType(ContentType.JSON)
                .body(userJson)
        .when()
                .post("/api/users/register")
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @Order(4)
    public void shouldBeFindUserById() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/api/users/{id}", ID)
        .then()
                .statusCode(HttpStatus.OK.value())
                .body("id", equalTo(1));
    }

    @Test
    @Order(5)
    public void shouldBeFindUserByNotExistsId() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/api/users/{id}", 2)
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @Order(6)
    public void shouldBeFindUserByIncorrectId() {
        given()
                .contentType(ContentType.JSON)
        .when()
                .get("/api/users/{id}", -1)
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value());
    }

    @Test
    @Order(7)
    public void shouldBeFindUserByUsernameIsNull() {
        UserReqDto dto = new UserReqDto();
        dto.setEmail(TEST_EMAIL);
        final String userJson = new Gson().toJson(dto);

        given()
                .contentType(ContentType.JSON)
                .body(userJson)
        .when()
                .post("/api/users/register")
        .then()
                .statusCode(HttpStatus.BAD_REQUEST.value())
                .body("errors", notNullValue());
    }
}
