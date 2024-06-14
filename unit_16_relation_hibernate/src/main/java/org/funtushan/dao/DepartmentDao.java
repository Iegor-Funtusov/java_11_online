package org.funtushan.dao;

import org.funtushan.entity.Department;
import org.funtushan.entity.Employee;

public interface DepartmentDao extends CrudDao<Department> {

    boolean existsByName(String departmentName);
    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
    void detachEmployeeToDepartment(Long departmentId, Long employeeId);
}
