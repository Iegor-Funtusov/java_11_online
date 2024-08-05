package ua.com.alevel.persistence.repository;

import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.Product;
import ua.com.alevel.persistence.entity.ProductImage;
import ua.com.alevel.persistence.type.ColorType;

@Repository
public interface ProductImageRepository extends BaseRepository<ProductImage> {

    ProductImage findByProductAndColorTypeAndMainIsTrue(Product product, ColorType colorType);
}
