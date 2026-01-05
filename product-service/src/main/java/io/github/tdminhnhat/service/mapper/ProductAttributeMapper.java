package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.ProductAttribute;
import io.github.tdminhnhat.service.model.dto.ProductAttributeDto;
import io.github.tdminhnhat.service.model.vo.ProductAttributeVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductAttributeMapper {

    ProductAttribute toEntity(ProductAttributeDto request);

    ProductAttributeVo toVo(ProductAttribute entity);
}
