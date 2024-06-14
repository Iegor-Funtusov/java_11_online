package org.funtushan.service;

import org.funtushan.entity.Department;

public interface DepartmentService extends CrudService<Department> {
    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
    void detachEmployeeToDepartment(Long departmentId, Long employeeId);
}
