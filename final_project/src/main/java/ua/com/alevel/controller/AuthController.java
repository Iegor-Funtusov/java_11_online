package ua.com.alevel.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.dto.req.UserReqDto;
import ua.com.alevel.dto.res.TokenResDto;
import ua.com.alevel.dto.res.UserResDto;
import ua.com.alevel.facade.UserFacade;

@RestController
@RequestMapping("/api/auth")
@AllArgsConstructor
public class AuthController {

    private final UserFacade userFacade;

    @PostMapping("/register")
    public ResponseEntity<UserResDto> register(@Valid @RequestBody UserReqDto dto) {
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(userFacade.createUser(dto));
    }

    @PostMapping("/login")
    public ResponseEntity<TokenResDto> login(@Valid @RequestBody UserReqDto dto) {
        return ResponseEntity.ok(userFacade.login(dto));
    }
}
