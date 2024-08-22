package ua.com.alevel.service;

import java.math.BigDecimal;

public interface ProductVariantService {
    BigDecimal findMinPriceByProductId(Long productId);
    BigDecimal findMaxPriceByProductId(Long productId);
}
