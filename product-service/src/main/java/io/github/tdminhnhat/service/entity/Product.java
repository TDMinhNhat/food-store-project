package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "foods")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Product extends BaseEntity {

    @Column(name = "product_name", length = 100, nullable = false) @NonNull
    String productName;

    @Column(name = "product_code", length = 50, nullable = false, unique = true) @NonNull
    String productCode;

    @Column(name = "description", columnDefinition = "TEXT DEFAULT ''")
    String description;

    @Column(name = "brand", length = 200, nullable = false) @NonNull
    String brand;

    @Column(name = "category_id", nullable = false) @NonNull
    Long categoryId;

    public Product(String note, @NonNull String productName, @NonNull String productCode, String description, @NonNull String brand, @NonNull Long categoryId) {
        super(note);
        this.productName = productName;
        this.productCode = productCode;
        this.description = description;
        this.brand = brand;
        this.categoryId = categoryId;
    }
}
