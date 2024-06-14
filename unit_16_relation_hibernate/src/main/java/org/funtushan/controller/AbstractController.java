package org.funtushan.controller;

import java.io.BufferedReader;
import java.io.IOException;

public abstract class AbstractController implements Controller {

    private final String element;
    
    public AbstractController(String element) {
        this.element = element;
    }

    @Override
    public void start(BufferedReader reader) {
        System.out.printf("Welcome to %s view!\n", element);
        String text;
        menu();
        try {
            while ((text = reader.readLine()) != null) {
                if (text.equals("6")) {
                    return;
                }
                goToOperations(text, reader);
                menu();
            }
        } catch (IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    @Override
    public void menu() {
        System.out.printf("If you want create %s please enter 1\n", element);
        System.out.printf("If you want find all %s please enter 2\n", element);
        System.out.printf("If you want find by id %s please enter 3\n", element);
        System.out.printf("If you want update %s please enter 4\n", element);
        System.out.printf("If you want delete %s please enter 5\n", element);
        System.out.printf("If you want exit %s enter 6\n", element);
    }

    @Override
    public void goToOperations(String text, BufferedReader reader) {
        switch (text) {
            case "1" -> create(reader);
            case "2" -> findAll();
            case "3" -> findById(reader);
            case "4" -> update(reader);
            case "5" -> delete(reader);
        }
    }
}
