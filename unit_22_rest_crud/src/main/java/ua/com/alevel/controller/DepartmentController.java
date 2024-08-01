package ua.com.alevel.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import ua.com.alevel.dto.req.DepartmentReqDto;
import ua.com.alevel.dto.res.DepartmentResDto;
import ua.com.alevel.facade.DepartmentFacade;

import java.util.Collection;

@Controller
@RequestMapping("/departments")
public class DepartmentController {

    @Autowired
    private DepartmentFacade departmentFacade;

//    @GetMapping
//    public Collection<Department> getAllDepartments() {
//        return departmentService.findAll();
//    }

//    @GetMapping
//    @ResponseBody
//    public String getAllDepartments() {
//        Collection<DepartmentResDto> departments = departmentFacade.findAll();
//        Gson gson = new Gson();
//        return gson.toJson(departments);
//    }

    @GetMapping
    @ResponseBody
    public Collection<DepartmentResDto> getAllDepartments() {
        return departmentFacade.findAll();
    }

    @GetMapping("/{id}")
    @ResponseBody
    public DepartmentResDto getById(@PathVariable Long id) {
        return departmentFacade.findById(id);
    }

    @PostMapping
    @ResponseBody
    public void create(@RequestBody DepartmentReqDto departmentReqDto) {
        departmentFacade.create(departmentReqDto);
    }

    @PutMapping("/{id}")
    @ResponseBody
    public void update(@RequestBody DepartmentReqDto departmentReqDto, @PathVariable Long id) {
        departmentFacade.update(departmentReqDto, id);
    }

    @DeleteMapping("/{id}")
    @ResponseBody
    public void delete(@PathVariable Long id) {
        departmentFacade.delete(id);
    }
}
