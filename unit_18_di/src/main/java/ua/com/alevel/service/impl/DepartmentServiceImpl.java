package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.Dependency;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.dao.DepartmentDao;
import ua.com.alevel.entity.Department;
import ua.com.alevel.service.DepartmentService;

import java.util.Collection;

@Service
public class DepartmentServiceImpl implements DepartmentService {

    @Dependency
    private DepartmentDao departmentDao;

    @Override
    public void create(Department entity) {
        departmentDao.create(entity);
    }

    @Override
    public void update(Department entity) {
        departmentDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        departmentDao.delete(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentDao.findById(id).orElseThrow(() -> new RuntimeException("Department not found"));
    }

    @Override
    public Collection<Department> findAll() {
        return departmentDao.findAll();
    }
}
