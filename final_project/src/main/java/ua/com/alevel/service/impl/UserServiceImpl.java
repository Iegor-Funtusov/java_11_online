package ua.com.alevel.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ua.com.alevel.exception.EntityNotFoundException;
import ua.com.alevel.exception.NotValidDataException;
import ua.com.alevel.exception.UnprocessableEntityException;
import ua.com.alevel.persistence.entity.user.User;
import ua.com.alevel.persistence.repository.UserRepository;
import ua.com.alevel.service.UserService;
import ua.com.alevel.util.ExceptionUtil;

@Service
@Transactional
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public void create(User user) {
        checkValidUser(user);
        userRepository.save(user);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.USER_NOT_FOUND_BY_EMAIL));
    }

    @Override
    public User findById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException(ExceptionUtil.USER_NOT_FOUND_BY_EMAIL));
    }

    private void checkValidUser(User user) {
        if (user.getId() != null) {
            throw new NotValidDataException(ExceptionUtil.USER_ALREADY_EXISTS_BY_ID);
        }
        if (user.getEmail() == null) {
            throw new NotValidDataException(ExceptionUtil.USER_EMAIL_IS_NOT_PRESENT);
        }
        if (userRepository.existsByEmail(user.getEmail())) {
            throw new UnprocessableEntityException(ExceptionUtil.USER_ALREADY_EXISTS_BY_EMAIL);
        }
        if (user.getPassword() == null) {
            throw new NotValidDataException(ExceptionUtil.USER_PASSWORD_IS_NOT_PRESENT);
        }
        if (user.getFirstName() == null) {
            throw new NotValidDataException(ExceptionUtil.USER_FIRST_NAME_IS_NOT_PRESENT);
        }
        if (user.getLastName() == null) {
            throw new NotValidDataException(ExceptionUtil.USER_LAST_NAME_IS_NOT_PRESENT);
        }
        if (user.getRole() == null) {
            throw new NotValidDataException(ExceptionUtil.USER_ROLE_IS_NOT_PRESENT);
        }
    }
}
