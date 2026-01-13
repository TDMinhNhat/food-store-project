package io.github.tdminhnhat.core.model.qo;

import org.springframework.data.domain.Sort;

public record SortRequestQo(

        String property,

        Sort.Direction direction

) {

    public Sort.Order getOrder() {
        return new Sort.Order(direction, property);
    }
}
