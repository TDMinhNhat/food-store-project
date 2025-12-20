package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "product_sku_details")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductSkuAttribute extends BaseEntity {

    @ManyToOne @JoinColumn(name = "product_sku_id", nullable = false) @NonNull
    ProductSku productSku;

    @ManyToOne @JoinColumn(name = "product_attribute_id", nullable = false) @NonNull
    Attribute attribute;

    @Column(name = "value", nullable = false, columnDefinition = "TEXT DEFAULT ''") @NonNull
    String value;

    public ProductSkuAttribute(String note, @NonNull ProductSku productSku, @NonNull Attribute attribute, @NonNull String value) {
        super(note);
        this.productSku = productSku;
        this.attribute = attribute;
        this.value = value;
    }
}
