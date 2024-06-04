package ua.com.alevel.service.impl;

import ua.com.alevel.dao.EmployeeDao;
import ua.com.alevel.dao.impl.EmployeeDaoImpl;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeDao employeeDao = new EmployeeDaoImpl();

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
