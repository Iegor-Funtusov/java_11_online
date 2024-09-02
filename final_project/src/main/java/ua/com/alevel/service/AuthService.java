package ua.com.alevel.service;

import ua.com.alevel.persistence.entity.user.Token;
import ua.com.alevel.persistence.entity.user.User;

public interface AuthService {

    Token login(User user);
}
