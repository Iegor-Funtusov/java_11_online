package ua.com.alevel.persistence.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Digits;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.type.ColorType;

import java.math.BigDecimal;

@Getter
@Setter
@Entity
@Table(name = "product_variants")
public class ProductVariant extends BaseEntity {

    @Column(nullable = false)
    private String cpu;

    @Column(nullable = false)
    private Integer ram;

    @Column(nullable = false)
    private Integer ssd;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ColorType colorType;

    @Column(nullable = false)
    @Digits(integer = 6, fraction = 2)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer quantity;

    @ManyToOne
    private Product product;
}
