package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record ProductAttributeDto(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String attributeName,

        @Positive(message = "must be a positive number")
        Long attributeParentId,

        String attributeDescription,

        String note
) {
}
