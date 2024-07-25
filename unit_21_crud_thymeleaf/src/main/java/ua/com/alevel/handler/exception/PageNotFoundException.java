package ua.com.alevel.handler.exception;

public class PageNotFoundException extends RuntimeException {

    public PageNotFoundException(String message) {
        super(message);
    }
}
