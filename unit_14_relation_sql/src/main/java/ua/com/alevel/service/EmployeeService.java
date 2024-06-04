package ua.com.alevel.service;

import ua.com.alevel.entity.Employee;

import java.util.Collection;

public interface EmployeeService extends CrudService<Employee> {

    Collection<Employee> findAllByDepartment(Long departmentId);
    void addEmployeeToDepartment(Long employeeId, Long departmentId);
    void deleteEmployeeFromDepartment(Long employeeId, Long departmentId);
}
