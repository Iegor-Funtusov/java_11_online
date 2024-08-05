package ua.com.alevel.persistence.service;

import ua.com.alevel.persistence.entity.Product;
import ua.com.alevel.persistence.entity.ProductImage;
import ua.com.alevel.persistence.type.ColorType;

public interface ProductImageService {

    ProductImage findByProductAndColorType(Product product, ColorType colorType);
}
