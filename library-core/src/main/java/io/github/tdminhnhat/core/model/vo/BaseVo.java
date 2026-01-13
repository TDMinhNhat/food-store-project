package io.github.tdminhnhat.core.model.vo;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.time.Instant;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@AllArgsConstructor
public class BaseVo {

    Long id;

    Boolean deleted;

    String note;

    Instant createdAt;

    Instant lastModifiedAt;

    String createdBy;

    String lastModifiedBy;

    Long version;
}
