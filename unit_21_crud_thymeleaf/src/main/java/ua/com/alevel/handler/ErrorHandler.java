package ua.com.alevel.handler;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.resource.NoResourceFoundException;
import ua.com.alevel.handler.exception.PageNotFoundException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(PageNotFoundException.class)
    public String redirectToCustomPageNotFound(final Model model, final PageNotFoundException exception) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "pages/404";
    }

    @ExceptionHandler(NoResourceFoundException.class)
    public String redirectToDefaultPageNotFound(final Model model, final NoResourceFoundException exception) {
        model.addAttribute("errorMessage", exception.getMessage());
        return "pages/404";
    }

    @ExceptionHandler(Exception.class)
    public String redirectToGlobalErrorPage(final Model model, final Exception exception) {
        exception.printStackTrace();
        model.addAttribute("errorMessage", exception.getMessage());
        return "pages/error";
    }
}
