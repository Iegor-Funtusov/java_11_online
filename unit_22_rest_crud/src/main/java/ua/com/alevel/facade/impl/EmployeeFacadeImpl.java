package ua.com.alevel.facade.impl;

import org.springframework.stereotype.Service;
import ua.com.alevel.dto.req.EmployeeReqDto;
import ua.com.alevel.dto.res.EmployeeResDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.facade.EmployeeFacade;
import ua.com.alevel.service.EmployeeService;

import java.util.Collection;

@Service
public class EmployeeFacadeImpl implements EmployeeFacade {

    private final EmployeeService employeeService;

    public EmployeeFacadeImpl(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @Override
    public void create(EmployeeReqDto employeeReqDto) {
        Employee employee = new Employee();
        employee.setFirstName(employeeReqDto.getFirstName());
        employee.setLastName(employeeReqDto.getLastName());
        employee.setBirthDay(employeeReqDto.getBirthDay());
        employeeService.save(employee);
    }

    @Override
    public void update(EmployeeReqDto employeeReqDto, Long id) {
        Employee employee = employeeService.findById(id);
        employee.setFirstName(employeeReqDto.getFirstName());
        employee.setLastName(employeeReqDto.getLastName());
        employee.setBirthDay(employeeReqDto.getBirthDay());
        employeeService.update(employee);
    }

    @Override
    public void delete(Long id) {
        employeeService.delete(id);
    }

    @Override
    public EmployeeResDto findById(Long id) {
        return new EmployeeResDto(employeeService.findById(id));
    }

    @Override
    public Collection<EmployeeResDto> findAll() {
        return employeeService.findAll().stream().map(EmployeeResDto::new).toList();
    }
}
