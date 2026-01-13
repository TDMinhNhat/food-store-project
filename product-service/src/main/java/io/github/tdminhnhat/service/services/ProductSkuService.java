package io.github.tdminhnhat.service.services;

import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.service.mapper.ProductSkuMapper;
import io.github.tdminhnhat.service.model.dto.ProductSkuDto;
import io.github.tdminhnhat.service.repository.ProductSkuRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductSkuService implements IService<ProductSkuDto, Long> {

    ProductSkuRepository productSkuRepository;
    ProductSkuMapper productSkuMapper;

    @Override
    public ResponseEntity<? extends BaseVo> add(ProductSkuDto request) throws Exception {
        return null;
    }

    @Override
    public ResponseEntity<? extends BaseVo> update(Long id, ProductSkuDto request) throws Exception {
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
