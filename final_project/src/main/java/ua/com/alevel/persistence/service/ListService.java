package ua.com.alevel.persistence.service;

import ua.com.alevel.persistence.entity.BaseEntity;

import java.util.List;

public interface ListService<E extends BaseEntity> {

    List<E> findAll();
}
