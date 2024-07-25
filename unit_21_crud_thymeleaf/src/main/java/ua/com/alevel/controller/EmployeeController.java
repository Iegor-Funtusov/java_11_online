package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.EmployeeDto;
import ua.com.alevel.entity.Employee;
import ua.com.alevel.service.EmployeeService;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

    @Autowired
    public EmployeeService employeeService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("employees", employeeService.findAll());
        return "pages/employees/employees";
    }

    @GetMapping("/new")
    public String redirectToNewEmployee(Model model) {
        model.addAttribute("employee", new EmployeeDto());
        return "pages/employees/employee_new";
    }

    @PostMapping("/new")
    public String create(@ModelAttribute("employee") EmployeeDto employeeDto) throws ParseException {
        Employee employee = new Employee();
        employee.setFirstName(employeeDto.getFirstName());
        employee.setLastName(employeeDto.getLastName());
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd", Locale.ENGLISH);
        Date date = formatter.parse(employeeDto.getBirthDay());
        employee.setBirthDay(date);
        employeeService.save(employee);
        return "redirect:/employees";
    }

    @GetMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        employeeService.delete(id);
        return "redirect:/employees";
    }
}
