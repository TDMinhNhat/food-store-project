package io.github.tdminhnhat.service.services;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.mapper.ProductSkuAttributeMapper;
import io.github.tdminhnhat.service.model.dto.ProductSkuAttributeDto;
import io.github.tdminhnhat.service.repository.ProductSkuAttributeRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductSkuAttributeService implements IService<ProductSkuAttributeDto, Long> {

    ProductSkuAttributeRepository productSkuAttributeRepository;
    ProductSkuAttributeMapper productSkuAttributeMapper;

    @Override
    public ResponseEntity<? extends BaseVo> add(ProductSkuAttributeDto request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<? extends BaseVo> update(Long id, ProductSkuAttributeDto request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<? extends BaseVo> getById(Long id) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<? extends BaseVo> delete(Long id) throws Exception {
        return null;
    }

    @Override
    public <C extends List<BaseVo>> ResponseEntity<C> getAll() throws Exception {
        return null;
    }
}
