package ua.com.alevel.controller;

import ua.com.alevel.entity.Department;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.impl.DepartmentServiceImpl;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collection;

public class DepartmentController {
    
    private final DepartmentService departmentService = new DepartmentServiceImpl();

    public void start(BufferedReader reader) throws IOException {
        System.out.println("Welcome to department view!");
        String text;
        menu();
        while ((text = reader.readLine()) != null) {
            if (text.equals("6")) {
                return;
            }
            goToOperations(text, reader);
            menu();
        }
    }

    private void menu() {
        System.out.println("If you want create department please enter 1");
        System.out.println("If you want find all departments please enter 2");
        System.out.println("If you want find by id department please enter 3");
        System.out.println("If you want update department please enter 4");
        System.out.println("If you want delete department please enter 5");
        System.out.println("If you want exit please enter 6");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> create(reader);
            case "2" -> findAll();
            case "3" -> findById(reader);
            case "4" -> update(reader);
            case "5" -> delete(reader);
        }
    }

    private void create(BufferedReader reader) throws IOException {
        System.out.println("Please enter the name of the department");
        String name = reader.readLine();

        Department department = new Department();
        department.setName(name);

        departmentService.create(department);
    }

    private void update(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the department");
        String id = reader.readLine();
        System.out.println("Please enter the name of the department");
        String name = reader.readLine();

        Department department = new Department();
        department.setId(Long.parseLong(id));
        department.setName(name);

        departmentService.update(department);
    }

    private void findById(BufferedReader reader) throws IOException {
        System.out.println("Please enter id of the department");
        String id = reader.readLine();

        Department department = departmentService.findById(Long.parseLong(id));
        System.out.println("Id " + department.getId());
        System.out.println("Name " + department.getName());
    }

    private void delete(BufferedReader reader) throws IOException {
        System.out.println("Please enter the id of the department you would like to delete");
        String id = reader.readLine();
        departmentService.delete(Long.parseLong(id));
    }

    private void findAll() {
        Collection<Department> departments = departmentService.findAll();
        for (Department department : departments) {
            System.out.println("Id " + department.getId());
            System.out.println("Name " + department.getName());
        }
    }
}
