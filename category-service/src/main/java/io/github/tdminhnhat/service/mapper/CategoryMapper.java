package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.Category;
import io.github.tdminhnhat.service.model.dto.CategoryDto;
import io.github.tdminhnhat.service.model.vo.CategoryVo;
import org.mapstruct.Mapper;
import org.mapstruct.NullValuePropertyMappingStrategy;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.SET_TO_NULL)
public interface CategoryMapper {

    Category toEntity(CategoryDto request);

    CategoryVo toVo(Category category);
}
