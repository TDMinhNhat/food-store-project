package io.github.tdminhnhat.service.entity;

import io.github.tdminhnhat.core.entity.BaseEntity;
import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Entity @Table(name = "categories")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class Category extends BaseEntity {

    @Column(name = "type_name", length = 50, nullable = false, unique = true) @NonNull
    String typeName;

    @ManyToOne @JoinColumn(name = "category_parent")
    Category categoryParent;

    @Column(name = "image_id", length = 100)
    String imageId;

    @Column(name = "description", columnDefinition = "TEXT DEFAULT ''")
    String description;

    public Category(String note, @NonNull String typeName, Category categoryParent, String imageId, String description) {
        super(note);
        this.typeName = typeName;
        this.categoryParent = categoryParent;
        this.imageId = imageId;
        this.description = description;
    }
}
