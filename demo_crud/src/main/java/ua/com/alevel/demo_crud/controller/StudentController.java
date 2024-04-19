package ua.com.alevel.demo_crud.controller;

import lombok.AllArgsConstructor;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.demo_crud.entity.Student;
import ua.com.alevel.demo_crud.service.StudentService;

@Controller
@RequestMapping("/students")
@AllArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping
    public String findAll(Model model) {
        model.addAttribute("students", studentService.findAll());
        return "pages/students";
    }

    @GetMapping("/new")
    public String redirectToNewStudentPage(Model model) {
        model.addAttribute("student", new Student());
        return "pages/student_new";
    }

    @PostMapping("/new")
    public String createStudent(@ModelAttribute Student student) {
        studentService.create(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/update")
    public String redirectToUpdateStudentPage(@PathVariable Long id, Model model) {
        model.addAttribute("student", studentService.findById(id));
        return "pages/student_update";
    }

    @PostMapping("/{id}/update")
    public String updateStudent(@PathVariable Long id, @ModelAttribute Student student) {
        student.setId(id);
        studentService.update(student);
        return "redirect:/students";
    }

    @GetMapping("/{id}/delete")
    public String deleteStudent(@PathVariable Long id) {
        studentService.delete(id);
        return "redirect:/students";
    }
}
