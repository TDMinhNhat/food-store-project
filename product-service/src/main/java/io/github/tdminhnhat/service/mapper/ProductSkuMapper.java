package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.ProductSku;
import io.github.tdminhnhat.service.model.dto.ProductSkuDto;
import io.github.tdminhnhat.service.model.vo.ProductSkuVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSkuMapper {

    ProductSku toEntity(ProductSkuDto request);

    ProductSkuVo toVo(ProductSku entity);
}
