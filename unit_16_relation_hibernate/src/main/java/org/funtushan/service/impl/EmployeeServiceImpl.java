package org.funtushan.service.impl;

import org.funtushan.dao.EmployeeDao;
import org.funtushan.dao.impl.EmployeeDaoImpl;
import org.funtushan.entity.Employee;
import org.funtushan.service.EmployeeService;

import java.util.Collection;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

    @Override
    public void save(Employee entity) {
        employeeDao.save(entity);
    }

    @Override
    public void update(Employee entity) {
        employeeDao.update(entity);
    }

    @Override
    public void delete(Long id) {
        employeeDao.delete(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeDao.findById(id).orElseThrow(() -> new RuntimeException("employee not find"));
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeDao.findAll();
    }
}
