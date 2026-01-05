package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.ProductSkuAttribute;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductSkuAttributeRepository extends JpaRepository<ProductSkuAttribute, Long> {
}
