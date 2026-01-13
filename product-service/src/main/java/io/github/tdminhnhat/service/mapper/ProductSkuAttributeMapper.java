package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.ProductSkuAttribute;
import io.github.tdminhnhat.service.model.dto.ProductSkuAttributeDto;
import io.github.tdminhnhat.service.model.vo.ProductSkuAttributeVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductSkuAttributeMapper {

    ProductSkuAttribute toEntity(ProductSkuAttributeDto request);

    ProductSkuAttributeVo toVo(ProductSkuAttribute entity);
}
