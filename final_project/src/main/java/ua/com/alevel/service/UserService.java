package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.user.User;

public interface UserService {

    void create(User user);
    User findByEmail(String email);
    User findById(Long id);
}
