package ua.com.alevel.service.impl;

import ua.com.alevel.annotations.Dependency;
import ua.com.alevel.annotations.Service;
import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Dependency
    private EmployeeDao employeeDao;

    @Override
    public void create(Employee entity) {
        employeeDao.create(entity);
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
        return employeeDao.findById(id).orElseThrow(() -> new RuntimeException("Employee not found"));
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeDao.findAll();
    }

    @Override
    public Collection<Employee> findAllByDepartment(Long departmentId) {
        return employeeDao.findAllByDepartment(departmentId);
    }

    @Override
    public void addEmployeeToDepartment(Long employeeId, Long departmentId) {
        employeeDao.addEmployeeToDepartment(employeeId, departmentId);
    }

    @Override
    public void deleteEmployeeFromDepartment(Long employeeId, Long departmentId) {
        employeeDao.deleteEmployeeFromDepartment(employeeId, departmentId);
    }
}
