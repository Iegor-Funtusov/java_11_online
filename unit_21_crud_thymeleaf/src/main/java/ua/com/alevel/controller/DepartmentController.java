package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.AttachEmployeeToDepartment;
import ua.com.alevel.entity.Department;
import ua.com.alevel.service.DepartmentService;
import ua.com.alevel.service.EmployeeService;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("departments", departmentService.findAll());
        return "pages/departments/departments";
    }

    @GetMapping("/{id}")
    public String findById(@PathVariable Long id, Model model) {
        model.addAttribute("data", new AttachEmployeeToDepartment());
        model.addAttribute("department", departmentService.findById(id));
        model.addAttribute("employees", employeeService.findAllEmployeesNotExistsInDepartment(id));
        return "pages/departments/department_details";
    }

    @GetMapping("new")
    public String redirectToNewDepartment(Model model) {
        model.addAttribute("department", new Department());
        return "pages/departments/department_new";
    }

    @PostMapping("new")
    public String create(@ModelAttribute Department department) {
        departmentService.save(department);
        return "redirect:/departments";
    }

    @PostMapping("/{id}/attach")
    public String attachEmployeeToDepartment(@PathVariable Long id, @ModelAttribute AttachEmployeeToDepartment data) {
        departmentService.attachEmployeeToDepartment(id, data.getEmployeeId());
        return "redirect:/departments/" + id;
    }
}
