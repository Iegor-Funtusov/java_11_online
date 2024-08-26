package ua.com.alevel.controller;

import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import ua.com.alevel.dto.req.UserReqDto;
import ua.com.alevel.dto.res.UserResDto;
import ua.com.alevel.facade.UserFacade;

@Validated
@RestController
@RequestMapping("/api/users")
@AllArgsConstructor
public class UserController {

    private final UserFacade userFacade;

    @PostMapping("/register")
    public ResponseEntity<UserResDto> create(@Valid @RequestBody UserReqDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userFacade.createUser(dto));
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResDto> findById(@Min(1) @PathVariable Long id) {
        return ResponseEntity
                .ok(userFacade.findById(id));
    }
}
