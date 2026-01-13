package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.Positive;

public record ProductSkuAttributeDto(

        @Positive(message = "must be a positive number")
        Long productAttributeId,

        String value
) {
}
