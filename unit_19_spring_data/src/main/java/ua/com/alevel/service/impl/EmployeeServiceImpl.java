package ua.com.alevel.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.repository.EmployeeRepository;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public void save(Employee entity) {
//        employeeDao.save(entity);
    }

    @Override
    public void update(Employee entity) {
//        employeeDao.update(entity);
    }

    @Override
    public void delete(Long id) {
//        employeeDao.delete(id);
    }

    @Override
    public Employee findById(Long id) {
        return null;
//        return employeeDao.findById(id).orElseThrow(() -> new RuntimeException("employee not find"));
    }

    @Override
    public Collection<Employee> findAll() {
        return null;
//        return employeeDao.findAll();
    }
}
