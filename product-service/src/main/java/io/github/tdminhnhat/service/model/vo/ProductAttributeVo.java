package io.github.tdminhnhat.service.model.vo;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductAttributeVo extends BaseVo {

    String attributeName;

    ProductAttributeVo productAttributeParent;

    String attributeDescription;

}
