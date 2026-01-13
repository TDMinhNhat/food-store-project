package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.Product;
import io.github.tdminhnhat.service.model.dto.ProductDto;
import io.github.tdminhnhat.service.model.vo.ProductVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    Product toEntity(ProductDto request);

    ProductVo toVo(Product entity);
}
