package io.github.tdminhnhat.core.model.dto;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public record PageRequestDto(

        Integer page,

        Integer size,

        List<SortRequestDto> sorts
){

    public Pageable getPageable() {
        return PageRequest.of(page, size, Sort.by(sorts.stream().map(SortRequestDto::getOrder).toList()));
    }
}
