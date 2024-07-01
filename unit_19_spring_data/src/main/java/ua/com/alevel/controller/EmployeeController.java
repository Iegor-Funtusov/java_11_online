package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.io.BufferedReader;
import java.util.Collection;

@Service
public class EmployeeController extends AbstractController {

    @Autowired
    private EmployeeService employeeService;

    public EmployeeController() {
        super("employee");
    }

    @Override
    public void create(BufferedReader reader) {
        try {
            System.out.println("Please enter the first name of the employee");
            String firstName = reader.readLine();
            System.out.println("Please enter the last name of the employee");
            String lastName = reader.readLine();
            System.out.println("Please enter the age of the employee");
            int age = Integer.parseInt(reader.readLine());

            Employee employee = new Employee();
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setAge(age);
            employeeService.save(employee);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void update(BufferedReader reader) {
        try {
            System.out.println("Please enter the id of the department");
            Long id = Long.parseLong(reader.readLine());
            System.out.println("Please enter the first name of the employee");
            String firstName = reader.readLine();
            System.out.println("Please enter the last name of the employee");
            String lastName = reader.readLine();
            System.out.println("Please enter the age of the employee");
            int age = Integer.parseInt(reader.readLine());

            Employee employee = employeeService.findById(id);
            employee.setFirstName(firstName);
            employee.setLastName(lastName);
            employee.setAge(age);
            employeeService.update(employee);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void delete(BufferedReader reader) {
        try {
            System.out.println("Please enter the id of the department");
            Long id = Long.parseLong(reader.readLine());
            employeeService.delete(id);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void findById(BufferedReader reader) {
        try {
            System.out.println("Please enter the id of the department");
            Long id = Long.parseLong(reader.readLine());
            Employee employee = employeeService.findById(id);
            System.out.println(employee);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void findAll() {
        Collection<Employee> employees = employeeService.findAll();
        employees.forEach(System.out::println);
    }
}
