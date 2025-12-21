package io.github.tdminhnhat.service.model.vo;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.service.entity.Category;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class CategoryVo extends BaseVo {

    String categoryName;

    Category categoryParent;

    String imageId;

    String imageUrl;

    String description;
}
