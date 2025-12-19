package io.github.tdminhnhat.core.model.dto;

import org.springframework.data.domain.Sort;

public record SortRequestDto(

        String property,

        Sort.Direction direction

) {

    public Sort.Order getOrder() {
        return new Sort.Order(direction, property);
    }
}
