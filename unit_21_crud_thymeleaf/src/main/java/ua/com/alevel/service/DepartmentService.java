package ua.com.alevel.service;

import ua.com.alevel.entity.Department;

public interface DepartmentService extends CrudService<Department> {

    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
}
