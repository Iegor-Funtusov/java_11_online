package ua.com.alevel.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product extends BaseEntity {

    @Column(nullable = false, unique = true)
    private String name;

    @Column(nullable = false)
    private String display;

    @Column(nullable = false)
    private String resolution;

    @Column(nullable = false)
    private String camera;

    @Column(nullable = false)
    private String battery;

    @Column(nullable = false)
    private String dimensions;

    @Column(nullable = false)
    private String weight;
}
