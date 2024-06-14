package org.funtushan.service;

import org.funtushan.entity.BaseEntity;

import java.util.Collection;

public interface CrudService<E extends BaseEntity> {

    void save(E entity);
    void update(E entity);
    void delete(Long id);
    E findById(Long id);
    Collection<E> findAll();
}
