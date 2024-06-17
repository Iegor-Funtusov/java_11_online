package ua.com.alevel.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainController {

    private final EmployeeController employeeController = new EmployeeController();
    private final DepartmentController departmentController = new DepartmentController();

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
        System.out.println("If you want observe employee please enter 1");
        System.out.println("If you want observe department please enter 2");
        System.out.println("If you want exit please enter 3");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> employeeController.start(reader);
            case "2" -> departmentController.start(reader);
            case "3" -> System.exit(0);
        }
    }

}
