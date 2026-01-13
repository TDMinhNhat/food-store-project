package io.github.tdminhnhat.service.services;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.entity.Product;
import io.github.tdminhnhat.service.mapper.ProductMapper;
import io.github.tdminhnhat.service.mapper.ProductSkuAttributeMapper;
import io.github.tdminhnhat.service.mapper.ProductSkuMapper;
import io.github.tdminhnhat.service.model.dto.ProductDto;
import io.github.tdminhnhat.service.model.vo.ProductVo;
import io.github.tdminhnhat.service.repository.ProductRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductService implements IService<ProductDto, Long> {

    ProductRepository productRepository;
    ProductMapper productMapper;

    @Transactional(rollbackOn = Exception.class
    )
    @Override
    public ResponseEntity<ProductVo> add(ProductDto request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<ProductVo> update(Long id, ProductDto request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<ProductVo> getById(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<ProductVo> delete(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<List<ProductVo>> getAll() throws Exception {
        return null;
    }

    private ProductVo getProductVo(Product product) {
        ProductVo productVo = productMapper.toVo(product);

        return productVo;
    }
}
