package ua.com.alevel.controller;

import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.req.EmployeeReqDto;
import ua.com.alevel.dto.res.EmployeeResDto;
import ua.com.alevel.facade.EmployeeFacade;

import java.util.Collection;

@Tag(name = "Employee resource", description = "CRUD operation with employee")
@RestController
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeFacade employeeFacade;

    public EmployeeController(EmployeeFacade employeeFacade) {
        this.employeeFacade = employeeFacade;
    }

    @PostMapping
    public ResponseEntity<Boolean> addEmployee(@RequestBody EmployeeReqDto dto) {
        employeeFacade.create(dto);
        return ResponseEntity.status(HttpStatus.CREATED).body(true);
    }

    @GetMapping
    public ResponseEntity<Collection<EmployeeResDto>> getAllEmployees() {
        return ResponseEntity.ok(employeeFacade.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeResDto> getEmployeeById(@PathVariable Long id) {
        return ResponseEntity.ok(employeeFacade.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Boolean> updateEmployee(@RequestBody EmployeeReqDto dto, @PathVariable Long id) {
        employeeFacade.update(dto, id);
        return ResponseEntity.ok(true);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> deleteEmployee(@PathVariable Long id) {
        employeeFacade.delete(id);
        return ResponseEntity.ok(true);
    }
}
