package io.github.tdminhnhat.service.model.vo;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.service.enums.ProductStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDate;
import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductSkuVo extends BaseVo {

    String skuCode;

    String barCode;

    String description;

    LocalDate manufacturerDate;

    LocalDate expireDate;

    ProductStatus status;

    List<ProductSkuAttributeVo> productSkuAttributeVos;
}
