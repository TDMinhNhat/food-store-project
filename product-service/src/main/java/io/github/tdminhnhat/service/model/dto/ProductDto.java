package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;

import java.util.List;

public record ProductDto(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "maximum length is {max} characters")
        String productName,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String productCode,

        String description,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 200, message = "maximum length is {max} characters")
        String brand,

        @Positive(message = "must be a positive number")
        Long categoryId,

        List<ProductSkuDto> productSkus
) {
}
