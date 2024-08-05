package ua.com.alevel.persistence.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.Product;
import ua.com.alevel.persistence.repository.ProductRepository;
import ua.com.alevel.persistence.service.ProductService;

import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Override
    @Transactional(readOnly = true)
    public List<Product> findAll() {
        return productRepository.findAll();
    }
}
