package ua.com.alevel.dao;

import ua.com.alevel.datatable.DataTableReq;
import ua.com.alevel.datatable.DataTableRes;
import ua.com.alevel.entity.BaseEntity;

import java.util.Collection;
import java.util.Optional;

public interface CrudDao<E extends BaseEntity> {

    void save(E entity);
    void update(E entity);
    void delete(Long id);
    Optional<E> findById(Long id);
    Collection<E> findAll();
    DataTableRes<E> findAll(DataTableReq req);
}
