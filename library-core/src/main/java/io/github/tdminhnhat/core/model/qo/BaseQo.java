package io.github.tdminhnhat.core.model.qo;

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
public class BaseQo {

    Long id;

    Boolean deleted;

    Instant createdAt;

    Instant lastModifiedAt;

    String createdBy;

    String lastModifiedBy;

    Long version;

    PageRequestQo pageRequest;
}
