package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.Token;
import ua.com.alevel.persistence.entity.user.User;

import java.util.Optional;

@Repository
public interface TokenRepository extends BaseRepository<Token> {

    Optional<Token> findByToken(String token);
    Optional<Token> findByUser(User user);
}
