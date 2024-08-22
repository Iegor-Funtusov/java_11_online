package ua.com.alevel.persistence.facade.impl;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import ua.com.alevel.persistence.dto.ProductPlpDto;
import ua.com.alevel.persistence.entity.ProductImage;
import ua.com.alevel.persistence.facade.PlpFacade;
import ua.com.alevel.service.ProductImageService;
import ua.com.alevel.service.ProductService;
import ua.com.alevel.service.ProductVariantService;
import ua.com.alevel.persistence.type.ColorType;

import java.math.BigDecimal;
import java.util.List;

@Service
@AllArgsConstructor
public class PlpFacadeImpl implements PlpFacade {

    private final ProductService productService;
    private final ProductImageService productImageService;
    private final ProductVariantService productVariantService;

    @Override
    public List<ProductPlpDto> findAll() {
        return productService.findAll()
                .stream()
                .map(product -> {
                    Long productId = product.getId();
                    String productName = product.getName();
                    ProductImage productImage = productImageService.findByProductAndColorType(product, ColorType.SILVER);
                    BigDecimal min = productVariantService.findMinPriceByProductId(productId);
                    BigDecimal max = productVariantService.findMaxPriceByProductId(productId);
                    if (min != null && max != null) {
                        return new ProductPlpDto(productId, productName, productImage.getUrl(), min.toString(), max.toString());
                    }
                    return new ProductPlpDto(productId, productName, productImage.getUrl(), "00.00", "00.00");
                })
                .toList();
    }
}
