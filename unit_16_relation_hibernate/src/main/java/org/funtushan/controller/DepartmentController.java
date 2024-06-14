package org.funtushan.controller;

import org.funtushan.entity.Department;
import org.funtushan.service.DepartmentService;
import org.funtushan.service.impl.DepartmentServiceImpl;

import java.io.BufferedReader;
import java.util.Collection;

public class DepartmentController extends AbstractController {

    private final DepartmentService departmentService = new DepartmentServiceImpl();

    public DepartmentController() {
        super("department");
    }

    @Override
    public void create(BufferedReader reader) {
        try {
            System.out.println("Please enter the name of the department");
            String name = reader.readLine();
            Department department = new Department();
            department.setName(name);
            departmentService.save(department);
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
            System.out.println("Please enter the name of the department");
            String name = reader.readLine();
            Department department = departmentService.findById(id);
            department.setName(name);
            departmentService.update(department);
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
            departmentService.delete(id);
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
            Department department = departmentService.findById(id);
            System.out.println("department = " + department);
        } catch (Exception e) {
            System.out.println("e = " + e.getMessage());
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void findAll() {
        Collection<Department> departments = departmentService.findAll();
        departments.forEach(System.out::println);
//        departments.forEach(department -> {
//            System.out.println("id: " + department.getId());
//            System.out.println("name: " + department.getName());
//        });
    }
}
