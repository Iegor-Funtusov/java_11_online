package ua.com.alevel;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Calculator {

    void start() throws IOException {
        System.out.println("Welcome to Calculator!");
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String text;
        menu();
        while ((text = reader.readLine()) != null) {
            goToOperations(text, reader);
            menu();
        }
    }

    void menu() {
        System.out.println("If you want find sum please enter 1");
        System.out.println("If you want find sub please enter 2");
        System.out.println("If you want find mul please enter 3");
        System.out.println("If you want find div please enter 4");
        System.out.println("If you want exit please enter 5");
    }

    void goToOperations(String text, BufferedReader reader) throws IOException {
        switch (text) {
            case "1" -> sum(reader);
            case "2" -> sub(reader);
            case "3" -> mul(reader);
            case "4" -> div(reader);
            case "5" -> System.exit(0);
        }
    }

    void sum(BufferedReader reader) throws IOException {
        System.out.println("Please enter a left number");
        int left = Integer.parseInt(reader.readLine());
        System.out.println("Please enter a right number");
        int right = Integer.parseInt(reader.readLine());
        int sum = left + right;
        System.out.println("sum = " + sum);
    }

    void sub(BufferedReader reader) throws IOException {
        System.out.println("Please enter a left number");
        int left = Integer.parseInt(reader.readLine());
        System.out.println("Please enter a right number");
        int right = Integer.parseInt(reader.readLine());
        int sub = left - right;
        System.out.println("sub = " + sub);
    }

    void mul(BufferedReader reader) throws IOException {
        System.out.println("Please enter a left number");
        int left = Integer.parseInt(reader.readLine());
        System.out.println("Please enter a right number");
        int right = Integer.parseInt(reader.readLine());
        int mul = left * right;
        System.out.println("mul = " + mul);
    }

    void div(BufferedReader reader) throws IOException {
        System.out.println("Please enter a left number");
        int left = Integer.parseInt(reader.readLine());
        System.out.println("Please enter a right number");
        int right = Integer.parseInt(reader.readLine());
        int div = left / right;
        System.out.println("div = " + div);
    }
}
