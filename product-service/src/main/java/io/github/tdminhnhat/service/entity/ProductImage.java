package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "product_images")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductImage extends BaseEntity {

    @ManyToOne @JoinColumn(name = "product_id", nullable = false) @NonNull
    Product product;

    @Column(name = "image_id", length = 100, unique = true)
    String imageId;

    @Column(name = "display_main", nullable = false) @NonNull
    Boolean displayMain;

    public ProductImage(String note, @NonNull Product product, String imageId, @NonNull Boolean displayMain) {
        super(note);
        this.product = product;
        this.imageId = imageId;
        this.displayMain = displayMain;
    }
}
