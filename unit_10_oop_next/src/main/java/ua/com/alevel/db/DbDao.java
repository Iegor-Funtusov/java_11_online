package ua.com.alevel.db;

import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface DbDao <E extends BaseEntity> {
    void create(E entity);
    void update(E entity);
    void deleteById(String id);
    Optional<E> findById(String id);
    Collection<E> findAll();
}
