package ua.com.alevel.controller;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.com.alevel.persistence.dto.ProductPlpDto;
import ua.com.alevel.persistence.facade.PlpFacade;

import java.util.List;

@RestController
@RequestMapping("/api/products")
@AllArgsConstructor
public class PlpController {

    private final PlpFacade plpFacade;

    @GetMapping("/plp")
    public ResponseEntity<List<ProductPlpDto>> findAll() {
        return ResponseEntity.ok(plpFacade.findAll());
    }
}
