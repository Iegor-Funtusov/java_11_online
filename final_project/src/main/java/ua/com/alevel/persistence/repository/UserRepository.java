package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.user.User;

@Repository
public interface UserRepository extends BaseRepository<User> {

    boolean existsByEmail(String email);
}
