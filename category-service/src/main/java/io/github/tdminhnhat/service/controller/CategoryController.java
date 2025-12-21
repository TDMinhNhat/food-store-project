package io.github.tdminhnhat.service.controller;

import io.github.tdminhnhat.core.controller.IController;
import io.github.tdminhnhat.service.model.dto.CategoryDto;
import io.github.tdminhnhat.service.model.vo.CategoryVo;
import io.github.tdminhnhat.service.service.CategoryService;
import jakarta.validation.Valid;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;

@RestController
@RequestMapping("${api-path.category}")
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryController implements IController<CategoryDto, Long>{

    CategoryService categoryService;

    @PostMapping("/")
    @Override
    public ResponseEntity<CategoryVo> add(CategoryDto request) throws Exception {
        return categoryService.add(request);
    }

    @PutMapping("/{id}")
    @Override
    public ResponseEntity<CategoryVo> update(@PathVariable Long id, @Valid @RequestBody CategoryDto request) throws Exception {
        return categoryService.update(id, request);
    }

    @GetMapping("/{id}")
    @Override
    public ResponseEntity<CategoryVo> getById(@PathVariable Long id) throws Exception {
        return categoryService.getById(id);
    }

    @DeleteMapping("/{id}")
    @Override
    public ResponseEntity<CategoryVo> delete(@PathVariable Long id) throws Exception {
        return categoryService.delete(id);
    }

    @GetMapping
    @Override
    public ResponseEntity<Collection<CategoryVo>> getAll() throws Exception {
        return categoryService.getAll();
    }

    @PutMapping("/{id}/image")
    @Override
    public ResponseEntity<CategoryVo> addOrUpdateFile(@PathVariable Long id, @RequestPart MultipartFile file) throws Exception {
        return categoryService.addOrUpdateFile(id, file);
    }

    @DeleteMapping("/{id}/image")
    @Override
    public ResponseEntity<CategoryVo> deleteFile(@PathVariable Long id) throws Exception {
        return categoryService.deleteFile(id);
    }
}
