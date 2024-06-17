package ua.com.alevel.dao;

import ua.com.alevel.entity.Department;

public interface DepartmentDao extends CrudDao<Department> {

    boolean existsByName(String departmentName);
    void attachEmployeeToDepartment(Long departmentId, Long employeeId);
    void detachEmployeeToDepartment(Long departmentId, Long employeeId);
}
