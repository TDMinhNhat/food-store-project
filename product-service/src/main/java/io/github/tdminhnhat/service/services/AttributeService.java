package io.github.tdminhnhat.service.services;

import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.entity.ProductAttribute;
import io.github.tdminhnhat.service.mapper.ProductAttributeMapper;
import io.github.tdminhnhat.service.model.dto.ProductAttributeDto;
import io.github.tdminhnhat.service.model.vo.ProductAttributeVo;
import io.github.tdminhnhat.service.repository.ProductAttributeRepository;
import jakarta.transaction.Transactional;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class AttributeService implements IService<ProductAttributeDto, Long> {

    ProductAttributeRepository productAttributeRepository;
    ProductAttributeMapper productAttributeMapper;
    
    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<ProductAttributeVo> add(ProductAttributeDto request) throws Exception {
        ProductAttribute parent = productAttributeRepository.findById(request.attributeParentId()).orElseThrow(() -> new QueryNotFoundException("Parent attribute not found with id: " + request.attributeParentId()));
        ProductAttribute productAttribute = productAttributeMapper.toEntity(request);
        productAttribute.setProductAttributeParent(parent);
        return ResponseEntity.ok(this.getAttributeVo(productAttributeRepository.save(productAttribute)));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<ProductAttributeVo> update(Long id, ProductAttributeDto request) throws Exception {
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Attribute not found with id: " + id));
        BeanUtils.copyProperties(request, productAttribute);
        productAttribute = productAttributeRepository.save(productAttributeMapper.toEntity(request));
        productAttribute.setProductAttributeParent(request.attributeParentId() == null ? null : productAttributeRepository.findById(request.attributeParentId()).orElseThrow(() -> new QueryNotFoundException("Parent attribute not found with id: " + request.attributeParentId())));
        return ResponseEntity.ok(this.getAttributeVo(productAttribute));
    }

    @Override
    public ResponseEntity<ProductAttributeVo> getById(Long id) throws Exception {
        return ResponseEntity.ok(this.getAttributeVo(
                productAttributeRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Attribute not found with id: " + id))
        ));
    }

    @Override
    @Transactional(rollbackOn = Exception.class)
    public ResponseEntity<ProductAttributeVo> delete(Long id) throws Exception {
        ProductAttribute productAttribute = productAttributeRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Attribute not found with id: " + id));
        productAttribute.setDeleted(true);
        return ResponseEntity.ok(this.getAttributeVo(productAttributeRepository.save(productAttribute)));
    }

    @Override
    public ResponseEntity<List<ProductAttributeVo>> getAll() throws Exception {
        return ResponseEntity.ok(productAttributeRepository.findAll().stream().map(this::getAttributeVo).toList());
    }

    private ProductAttributeVo getAttributeVo(ProductAttribute productAttribute) {
        ProductAttributeVo result = productAttributeMapper.toVo(productAttribute);
        result.setProductAttributeParent(productAttributeMapper.toVo(productAttribute.getProductAttributeParent()));
        return result;
    }
}
