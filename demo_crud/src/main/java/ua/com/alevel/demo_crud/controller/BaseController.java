package ua.com.alevel.demo_crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class BaseController {

    @GetMapping
    public String main() {
        return "redirect:/students";
    }
}
