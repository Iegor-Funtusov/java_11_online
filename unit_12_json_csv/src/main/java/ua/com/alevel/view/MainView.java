package ua.com.alevel.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainView {

    private final StudentView studentView = new StudentView();
    private final GroupView groupView = new GroupView();

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
        System.out.println("If you want observe student please enter 1");
        System.out.println("If you want observe group please enter 2");
        System.out.println("If you want exit please enter 3");
    }

    private void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> studentView.start(reader);
            case "2" -> groupView.start(reader);
            case "3" -> System.exit(0);
        }
    }
}
