package io.github.tdminhnhat.service.enums;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

@Getter
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@AllArgsConstructor
public enum ProductStatus {

    DRAFT("Draft"), SELLING("Selling"), DISCONTINUED("Discontinued");

    String status;
}
