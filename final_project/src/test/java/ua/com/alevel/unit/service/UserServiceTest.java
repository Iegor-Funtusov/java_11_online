package ua.com.alevel.unit.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.boot.test.context.SpringBootTest;
import ua.com.alevel.exception.NotValidDataException;
import ua.com.alevel.exception.UnprocessableEntityException;
import ua.com.alevel.persistence.entity.user.RoleUser;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.UserRepository;
import ua.com.alevel.service.impl.UserServiceImpl;
import ua.com.alevel.util.ExceptionUtil;

import static org.assertj.core.api.Assertions.assertThat;
import static ua.com.alevel.util.TestUtil.*;

/**
 * onCreate
 * id - unique, must be null
 * email - unique, required
 * password - required
 * firstName - required
 * lastName - required
 * role - required
 */

@SpringBootTest
public class UserServiceTest {

    @InjectMocks
    private UserServiceImpl userService;

    @Mock
    private UserRepository userRepository;

    @Test
    public void shouldBeCreateUserWhereIdIsNotNull() {
        // given
        final User user = new User();
        user.setId(ID);

        // when
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.USER_ALREADY_EXISTS_BY_ID);
    }

    @Test
    public void shouldBeCreateUserWhereEmailIsNull() {
        // given
        final User user = new User();
        user.setEmail(null);

        // when
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.USER_EMAIL_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateUserWhereEmailIsExists() {
        // given
        final User user = new User();
        user.setEmail(TEST_EMAIL);
        Mockito.when(userRepository.existsByEmail(TEST_EMAIL)).thenReturn(true);

        // when
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));

        // then
        assertThat(thrown).isInstanceOf(UnprocessableEntityException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.USER_ALREADY_EXISTS_BY_EMAIL);
    }

    @Test
    public void shouldBeCreateUserWherePasswordIsNull() {
        // given
        final User user = new User();
        user.setEmail(TEST_EMAIL);
        user.setPassword(null);
        Mockito.when(userRepository.existsByEmail(TEST_EMAIL)).thenReturn(false);

        // when
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.USER_PASSWORD_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateUserWhereFirstNameIsNull() {
        // given
        final User user = new User();
        user.setEmail(TEST_EMAIL);
        user.setPassword(TEST_PASSWORD);
        user.setFirstName(null);
        Mockito.when(userRepository.existsByEmail(TEST_EMAIL)).thenReturn(false);

        // when
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.USER_FIRST_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateUserWhereLastNameIsNull() {
        // given
        final User user = new User();
        user.setEmail(TEST_EMAIL);
        user.setPassword(TEST_PASSWORD);
        user.setFirstName(FIRST_NAME);
        user.setLastName(null);
        Mockito.when(userRepository.existsByEmail(TEST_EMAIL)).thenReturn(false);

        // when
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.USER_LAST_NAME_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateUserWhereRoleIsNull() {
        // given
        final User user = new User();
        user.setEmail(TEST_EMAIL);
        user.setPassword(TEST_PASSWORD);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setRole(null);
        Mockito.when(userRepository.existsByEmail(TEST_EMAIL)).thenReturn(false);

        // when
        Exception thrown = Assertions.assertThrows(RuntimeException.class, () -> userService.create(user));

        // then
        assertThat(thrown).isInstanceOf(NotValidDataException.class);
        assertThat(thrown.getMessage()).isEqualTo(ExceptionUtil.USER_ROLE_IS_NOT_PRESENT);
    }

    @Test
    public void shouldBeCreateUserWhereDataIsValid() {
        // given
        final User user = new User();
        user.setEmail(TEST_EMAIL);
        user.setPassword(TEST_PASSWORD);
        user.setFirstName(FIRST_NAME);
        user.setLastName(LAST_NAME);
        user.setRole(RoleUser.ROLE_USER);
        Mockito.when(userRepository.existsByEmail(TEST_EMAIL)).thenReturn(false);

        // when
        userService.create(user);

        // then
        Mockito.verify(userRepository, Mockito.times(1)).save(user);
    }
}
