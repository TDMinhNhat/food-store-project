package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

public record CategoryDto(

        @Size(max = 50, message = "maximum length is {max} characters")
        @NotBlank(message = "can not be null or empty")
        String categoryName,

        @Positive(message = "must be a number greater than 0")
        Long categoryParentId,

        String description,

        String note
) {
}
