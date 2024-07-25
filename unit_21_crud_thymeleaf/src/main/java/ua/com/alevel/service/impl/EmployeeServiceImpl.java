package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.handler.exception.PageNotFoundException;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;
import java.util.List;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public void update(Employee entity) {
        employeeRepository.save(entity);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Employee findById(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new PageNotFoundException("employee not find"));
    }

    @Override
    public Collection<Employee> findAll() {
        return employeeRepository.findAll();
    }

    @Override
    public List<Employee> findAllEmployeesNotExistsInDepartment(Long id) {
        return employeeRepository.findAllEmployeesNotExistsInDepartment(id);
    }
}
