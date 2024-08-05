package ua.com.alevel.persistence.service.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ua.com.alevel.persistence.entity.ProductVariant;
import ua.com.alevel.persistence.repository.ProductVariantRepository;
import ua.com.alevel.persistence.service.ProductVariantService;

import java.math.BigDecimal;

@Service
@Transactional
@AllArgsConstructor
public class ProductVariantServiceImpl implements ProductVariantService {

    private final ProductVariantRepository productVariantRepository;

    @Override
    public BigDecimal findMinPriceByProductId(Long productId) {
        return productVariantRepository.findMinPriceByProductId(productId);
    }

    @Override
    public BigDecimal findMaxPriceByProductId(Long productId) {
        return productVariantRepository.findMaxPriceByProductId(productId);
    }
}
