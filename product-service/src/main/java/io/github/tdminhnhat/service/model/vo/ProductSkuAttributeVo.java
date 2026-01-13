package io.github.tdminhnhat.service.model.vo;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductSkuAttributeVo extends BaseVo {

    ProductAttributeVo productAttributeVo;

    String value;
}
