package org.funtushan.service.impl;

import org.funtushan.dao.DepartmentDao;
import org.funtushan.dao.impl.DepartmentDaoImpl;
import org.funtushan.entity.Department;
import org.funtushan.service.DepartmentService;

import java.util.Collection;

public class DepartmentServiceImpl implements DepartmentService {

    private final DepartmentDao departmentDao = new DepartmentDaoImpl();

    @Override
    public void save(Department entity) {
        if (departmentDao.existsByName(entity.getName())) {
            throw new RuntimeException("department already exist");
        }
        departmentDao.save(entity);
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
        return departmentDao.findById(id).orElseThrow(() -> new RuntimeException("department not found"));
    }

    @Override
    public Collection<Department> findAll() {
        return departmentDao.findAll();
    }

    @Override
    public void attachEmployeeToDepartment(Long departmentId, Long employeeId) {
        departmentDao.attachEmployeeToDepartment(departmentId, employeeId);
    }

    @Override
    public void detachEmployeeToDepartment(Long departmentId, Long employeeId) {
        departmentDao.detachEmployeeToDepartment(departmentId, employeeId);
    }
}
