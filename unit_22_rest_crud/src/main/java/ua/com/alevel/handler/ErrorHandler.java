package ua.com.alevel.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.resource.NoResourceFoundException;

@RestControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<String> redirectToCustomPageNotFound(final EntityNotFoundException exception) {
        exception.printStackTrace();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String redirectToDefaultPageNotFound(final NoResourceFoundException exception) {
        exception.printStackTrace();
        return "{}";
    }

    @ExceptionHandler(Exception.class)
    public String redirectToGlobalErrorPage(final Exception exception) {
        exception.printStackTrace();
        return "{}";
    }
}
