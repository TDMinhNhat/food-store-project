package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IController;
import io.github.tdminhnhat.service.model.dto.ProductAttributeDto;
import io.github.tdminhnhat.service.model.vo.ProductAttributeVo;
import io.github.tdminhnhat.service.services.AttributeService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("${api-path.attribute}")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class ProductAttributeController implements IController<ProductAttributeDto, Long> {
    
    AttributeService attributeService;

    @PostMapping
    @Override
    public ResponseEntity<ProductAttributeVo> add(@Valid @RequestBody ProductAttributeDto request) throws Exception {
        return attributeService.add(request);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<ProductAttributeVo> update(@PathVariable Long id, @Valid @RequestBody ProductAttributeDto request) throws Exception {
        return attributeService.update(id, request);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<ProductAttributeVo> getById(@PathVariable Long id) throws Exception {
        return attributeService.getById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<ProductAttributeVo> delete(@PathVariable Long id) throws Exception {
        return attributeService.delete(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<List<ProductAttributeVo>> getAll() throws Exception {
        return attributeService.getAll();
    }
}
