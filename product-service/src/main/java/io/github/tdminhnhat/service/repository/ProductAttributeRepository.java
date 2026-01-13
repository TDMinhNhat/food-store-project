package io.github.tdminhnhat.service.repository;

import io.github.tdminhnhat.service.entity.ProductAttribute;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductAttributeRepository extends ListCrudRepository<ProductAttribute, Long> {
}
