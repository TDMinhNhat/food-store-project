package io.github.tdminhnhat.core.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;

@MappedSuperclass
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@EntityListeners(AuditingEntityListener.class)
@DynamicInsert @DynamicUpdate
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", updatable = false, nullable = false)
    Long id;

    @Column(name = "deleted", nullable = false, columnDefinition = "BOOLEAN DEFAULT FALSE")
    Boolean deleted;

    @Column(name = "note", nullable = false, columnDefinition = "TEXT DEFAULT ''")
    String note;

    @CreatedDate
    @Column(name = "created_at", updatable = false, nullable = false)
    Instant createdAt;

    @LastModifiedDate
    @Column(name = "last_modified_at")
    Instant lastModifiedAt;

    @CreatedBy
    @Column(name = "created_by", updatable = false, nullable = false)
    String createdBy;

    @LastModifiedBy
    @Column(name = "last_modified_by")
    String lastModifiedBy;

    @Version
    @Column(name = "version", nullable = false)
    Long version;

    public BaseEntity(String note) {
        this.note = note;
    }
}
