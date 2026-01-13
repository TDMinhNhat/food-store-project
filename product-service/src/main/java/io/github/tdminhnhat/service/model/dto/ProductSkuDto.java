package io.github.tdminhnhat.service.model.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.util.List;

public record ProductSkuDto(

        @NotBlank(message = "can not be null or empty")
        @Size(max = 50, message = "maximum length is {max} characters")
        String skuCode,

        @NotBlank(message = "can not be null or empty")
        @Size(max = 100, message = "maximum length is {max} characters")
        String barCode,

        String description,

        @PastOrPresent(message = "must be a past or present date")
        LocalDate manufacturerDate,

        @FutureOrPresent(message = "must be a present or future date")
        LocalDate expireDate,

        List<ProductSkuAttributeDto> productSkuAttributes
) {
}
