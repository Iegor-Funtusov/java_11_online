package ua.com.alevel.persistence.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ua.com.alevel.persistence.entity.ProductVariant;

import java.math.BigDecimal;

@Repository
public interface ProductVariantRepository extends BaseRepository<ProductVariant> {

    @Query("select min(pv.price) from ProductVariant pv where pv.product.id = :productId and pv.quantity > 0")
    BigDecimal findMinPriceByProductId(Long productId);

    @Query("select max(pv.price) from ProductVariant pv where pv.product.id = :productId and pv.quantity > 0")
    BigDecimal findMaxPriceByProductId(Long productId);
}
