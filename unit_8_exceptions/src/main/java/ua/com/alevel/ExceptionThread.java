package ua.com.alevel;

import java.util.Random;

public class ExceptionThread extends Thread {

    public ExceptionThread(String name) {
        super(name);
    }

    @Override
    public void run() {
        System.out.println("Thread name = " + Thread.currentThread().getName());
        int random = new Random().nextInt(2);
        System.out.println("random = " + 10 / random);
    }
}
