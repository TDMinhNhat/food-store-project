package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import io.github.tdminhnhat.service.enums.ProductStatus;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;
import java.time.LocalDate;

@Entity @Table(name = "product_skus")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductSku extends BaseEntity {

    @ManyToOne @JoinColumn(name = "product_id", nullable = false) @NonNull
    Product product;

    @Column(name = "sku_code", length = 50, nullable = false, unique = true) @NonNull
    String skuCode;

    @Column(name = "bar_code", length = 100, unique = true) @NonNull
    String barCode;

    @Column(name = "description", columnDefinition = "TEXT DEFAULT ''")
    String description;

    @Column(name = "manufacture_date", nullable = false) @NonNull
    LocalDate manufactureDate;

    @Column(name = "expire_date")
    LocalDate expireDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", length = 50, nullable = false, columnDefinition = "VARCHAR(150) DEFAULT 'DRAFT'") @NonNull
    ProductStatus status;

    public ProductSku(String note, @NonNull Product product, @NonNull String skuCode, @NonNull String barCode, String description, @NonNull LocalDate manufactureDate, LocalDate expireDate, @NonNull ProductStatus status) {
        super(note);
        this.product = product;
        this.skuCode = skuCode;
        this.barCode = barCode;
        this.description = description;
        this.manufactureDate = manufactureDate;
        this.expireDate = expireDate;
        this.status = status;
    }
}
