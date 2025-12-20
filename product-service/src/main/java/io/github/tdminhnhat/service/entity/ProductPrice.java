package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;

@Entity @Table(name = "product_prices")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductPrice extends BaseEntity {

    @ManyToOne @JoinColumn(name = "product_sku_id", nullable = false) @NonNull
    ProductSku productSku;

    @Column(name = "price_date", nullable = false) @NonNull
    LocalDate priceDate;

    @Column(name = "price", nullable = false) @NonNull
    Double price;

    public ProductPrice(String note, @NonNull ProductSku productSku, @NonNull LocalDate priceDate, @NonNull Double price) {
        super(note);
        this.productSku = productSku;
        this.priceDate = priceDate;
        this.price = price;
    }
}
