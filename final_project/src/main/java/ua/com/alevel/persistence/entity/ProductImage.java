package ua.com.alevel.persistence.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import ua.com.alevel.persistence.type.ColorType;

@Getter
@Setter
@Entity
@Table(name = "product_images")
public class ProductImage extends BaseEntity {

    @Column(nullable = false)
    private String url;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private ColorType colorType;

    private Boolean main = false;

    @ManyToOne
    private Product product;
}
