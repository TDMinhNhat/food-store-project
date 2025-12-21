package io.github.tdminhnhat.service.mapper;

import io.github.tdminhnhat.service.entity.Category;
import io.github.tdminhnhat.service.model.dto.CategoryDto;
import io.github.tdminhnhat.service.model.vo.CategoryVo;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CategoryMapper {

    Category toEntity(CategoryDto request);

    CategoryVo toVo(Category category);
}
