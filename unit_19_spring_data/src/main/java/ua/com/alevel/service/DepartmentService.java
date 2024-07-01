package ua.com.alevel.service;

import ua.com.alevel.entity.Department;

public interface DepartmentService extends CrudService<Department> {
    void deleteByNameEndingWithIgnoreCase(String name);
    void deleteByNameContainingIgnoreCase(String name);
    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
    void detachEmployeeToDepartment(Long departmentId, Long employeeId);
}
