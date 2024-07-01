package ua.com.alevel.controller;

import java.io.BufferedReader;

public interface Controller {

    void start(BufferedReader reader);
    void menu();
    void goToOperations(String text, BufferedReader reader);
    void create(BufferedReader reader);
    void update(BufferedReader reader);
    void delete(BufferedReader reader);
    void findById(BufferedReader reader);
    void findAll();
}
