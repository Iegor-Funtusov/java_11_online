package ua.com.alevel.persistence.facade;

import ua.com.alevel.persistence.dto.ProductPlpDto;

import java.util.List;

public interface PlpFacade {

    List<ProductPlpDto> findAll();
}
