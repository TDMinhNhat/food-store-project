package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "product_attributes")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductAttribute extends BaseEntity {

    @Column(name = "attribute_name", length = 50, nullable = false, unique = true) @NonNull
    String attributeName;

    @ManyToOne @JoinColumn(name = "attribute_parent_id")
    ProductAttribute productAttributeParent;

    @Column(name = "description", columnDefinition = "TEXT DEFAULT ''")
    String description;

    public ProductAttribute(String note, @NonNull String attributeName, ProductAttribute productAttributeParent, String description) {
        super(note);
        this.attributeName = attributeName;
        this.productAttributeParent = productAttributeParent;
        this.description = description;
    }
}
