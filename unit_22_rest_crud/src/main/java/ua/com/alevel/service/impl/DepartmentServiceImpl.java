package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Department;
import ua.com.alevel.entity.Employee;

import ua.com.alevel.handler.EntityNotFoundException;
import ua.com.alevel.repository.DepartmentRepository;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    @Autowired
    private EmployeeService employeeService;

    @Override
    public void save(Department entity) {
        if (departmentRepository.existsByName(entity.getName())) {
            throw new RuntimeException("department already exist");
        }
        departmentRepository.save(entity);
    }

    @Override
    public void update(Department entity) {
        departmentRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        departmentRepository.deleteById(id);
    }

    @Override
    public Department findById(Long id) {
        return departmentRepository.findById(id).orElseThrow(() -> new EntityNotFoundException("department not found"));
    }

    @Override
    public Collection<Department> findAll() {
        return departmentRepository.findAll();
    }

    @Override
    public void attachEmployeeToDepartment(Long departmentId, Long employeeId) {
        Department department = findById(departmentId);
        Employee employee = employeeService.findById(employeeId);
        department.getEmployees().add(employee);
        departmentRepository.save(department);
    }
}
