package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "product_attributes")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Attribute extends BaseEntity {

    @Column(name = "attribute_name", length = 50, nullable = false, unique = true) @NonNull
    String attributeName;

    @Column(name = "description", columnDefinition = "TEXT DEFAULT ''")
    String description;

    public Attribute(String note, @NonNull String attributeName, String description) {
        super(note);
        this.attributeName = attributeName;
        this.description = description;
    }
}
