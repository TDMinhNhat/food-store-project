package io.github.tdminhnhat.core.model.qo;

import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

public record PageRequestQo(

        Integer page,

        Integer size,

        List<SortRequestQo> sorts
){

    public Pageable getPageable() {
        return PageRequest.of(page, size, Sort.by(sorts.stream().map(SortRequestQo::getOrder).toList()));
    }
}
