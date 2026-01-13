package io.github.tdminhnhat.service.model.vo;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.List;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class ProductVo extends BaseVo {

    String productName;

    String productCode;

    String brand;

    Long categoryId;

    List<ProductSkuVo> productSkuVos;
}
