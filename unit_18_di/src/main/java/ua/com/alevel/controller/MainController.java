package ua.com.alevel.controller;

import ua.com.alevel.annotations.Dependency;
import ua.com.alevel.annotations.MainClass;
import ua.com.alevel.annotations.MainMethod;
import ua.com.alevel.annotations.Service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

@Service
@MainClass
public class MainController {

    @Dependency
    private EmployeeController employeeController;
    @Dependency
    private DepartmentController departmentController;

    @MainMethod
    public void start() {
        System.out.println("Welcome to app view!");
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String text;
            menu();
            while ((text = reader.readLine()) != null) {
                goToOperations(text, reader);
                menu();
            }
        } catch (IOException e) {
            System.out.println("e = " + e);
        }
    }

    private void menu() {
        System.out.println("If you want observe departments please enter 1");
        System.out.println("If you want observe employees please enter 2");
        System.out.println("If you want exit please enter 3");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> departmentController.start(reader);
            case "2" -> employeeController.start(reader);
            case "3" -> System.exit(0);
        }
    }
}
