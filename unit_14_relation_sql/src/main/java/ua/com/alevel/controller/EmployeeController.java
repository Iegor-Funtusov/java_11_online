package ua.com.alevel.controller;

import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;
import ua.com.alevel.service.impl.EmployeeServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public class EmployeeController {
    
    private final EmployeeService employeeService = new EmployeeServiceImpl();

    public void start(BufferedReader reader) throws IOException {
        System.out.println("Welcome to employee view!");
        String text;
        menu();
        while ((text = reader.readLine()) != null) {
            if (text.equals("9")) {
                return;
            }
            goToOperations(text, reader);
            menu();
        }
    }

    private void menu() {
        System.out.println("If you want create employee please enter 1");
        System.out.println("If you want find all employees please enter 2");
        System.out.println("If you want find all employees by department please enter 3");
        System.out.println("If you want find by id employee please enter 4");
        System.out.println("If you want update employee please enter 5");
        System.out.println("If you want delete employee please enter 6");
        System.out.println("If you want add employee to department please enter 7");
        System.out.println("If you want delete employee from department please enter 8");
        System.out.println("If you want exit please enter 9");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> create(reader);
            case "2" -> findAll();
            case "3" -> findAllByDepartment(reader);
            case "4" -> findById(reader);
            case "5" -> update(reader);
            case "6" -> delete(reader);
            case "7" -> addEmployeeToDepartment(reader);
            case "8" -> deleteEmployeeFromDepartment(reader);
        }
    }

    private void create(BufferedReader reader) throws IOException {
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

        employeeService.create(employee);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the employee");
        String id = reader.readLine();
        System.out.println("Please enter the first name of the employee");
        String firstName = reader.readLine();
        System.out.println("Please enter the last name of the employee");
        String lastName = reader.readLine();
        System.out.println("Please enter the age of the employee");
        int age = Integer.parseInt(reader.readLine());

        Employee employee = new Employee();
        employee.setId(Long.parseLong(id));
        employee.setFirstName(firstName);
        employee.setLastName(lastName);
        employee.setAge(age);

        employeeService.update(employee);
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter id of the employee");
        String id = reader.readLine();


        Employee employee = employeeService.findById(Long.parseLong(id));
        System.out.println("Id " + employee.getId());
        System.out.println("First name " + employee.getFirstName());
        System.out.println("Last name " + employee.getLastName());
        System.out.println("Age " + employee.getAge());
    }

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the employee you would like to delete");
        String id = reader.readLine();
        employeeService.delete(Long.parseLong(id));
    }

    private void findAll() {
        Collection<Employee> employees = employeeService.findAll();
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void findAllByDepartment(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the department");
        String id = reader.readLine();
        Collection<Employee> employees = employeeService.findAllByDepartment(Long.parseLong(id));
        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    private void addEmployeeToDepartment(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the department");
        String departmentId = reader.readLine();
        System.out.println("Please enter the id of the employee");
        String employeeId = reader.readLine();
        employeeService.addEmployeeToDepartment(Long.parseLong(employeeId), Long.parseLong(departmentId));
    }

    private void deleteEmployeeFromDepartment(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the department");
        String departmentId = reader.readLine();
        System.out.println("Please enter the id of the employee");
        String employeeId = reader.readLine();
        employeeService.deleteEmployeeFromDepartment(Long.parseLong(employeeId), Long.parseLong(departmentId));
    }
}
