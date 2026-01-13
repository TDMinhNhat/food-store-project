package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IController;
import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.service.model.dto.ProductDto;
import io.github.tdminhnhat.service.model.vo.ProductVo;
import io.github.tdminhnhat.service.services.ProductService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api-path.product}")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductController implements IController<ProductDto, Long> {

    ProductService productService;

    @PostMapping
    @Override
    public ResponseEntity<ProductVo> add(@Valid @RequestBody ProductDto request) throws Exception {
        return productService.add(request);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ProductVo> update(@PathVariable Long id, @Valid @RequestBody ProductDto request) throws Exception {
        return productService.update(id, request);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ProductVo> getById(@PathVariable Long id) throws Exception {
        return productService.getById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ProductVo> delete(@PathVariable Long id) throws Exception {
        return productService.delete(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductVo>> getAll() throws Exception {
        return productService.getAll();
    }
}
