package ua.com.alevel.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.Product;
import ua.com.alevel.persistence.entity.ProductImage;
import ua.com.alevel.persistence.repository.ProductImageRepository;
import ua.com.alevel.service.ProductImageService;
import ua.com.alevel.persistence.type.ColorType;

@Service
@Transactional
@AllArgsConstructor
public class ProductImageServiceImpl implements ProductImageService {

    private final ProductImageRepository productImageRepository;

    @Override
    public ProductImage findByProductAndColorType(Product product, ColorType colorType) {
        return productImageRepository.findByProductAndColorTypeAndMainIsTrue(product, colorType);
    }
}
