package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.service.entity.Category;
import io.github.tdminhnhat.service.mapper.CategoryMapper;
import io.github.tdminhnhat.service.model.dto.CategoryDto;
import io.github.tdminhnhat.service.model.vo.CategoryVo;
import io.github.tdminhnhat.service.repository.CategoryRepository;
import lombok.AccessLevel;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE)
@RequiredArgsConstructor
public class CategoryService implements IService<CategoryDto, Long> {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;
    MinioUtil minioUtil;

    @Override
    public ResponseEntity<CategoryVo> add(CategoryDto request) throws Exception {
        return ResponseEntity.ok(this.getCategoryVo(categoryMapper.toEntity(request)));
    }

    @Override
    public ResponseEntity<CategoryVo> update(Long id, CategoryDto request) throws Exception {
        Category target = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        Category source = categoryMapper.toEntity(request);
        BeanUtils.copyProperties(source, target, "id");
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(target)));
    }

    @Override
    public ResponseEntity<CategoryVo> getById(Long id) throws Exception {
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"))));
    }

    @Override
    public ResponseEntity<CategoryVo> delete(Long id) throws Exception {
        Category target = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        target.setDeleted(true);
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(target)));
    }

    @Override
    public ResponseEntity<Collection<CategoryVo>> getAll() {
        return ResponseEntity.ok(categoryRepository.findAll().stream().map(category -> {
            try {
                return this.getCategoryVo(category);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList());
    }

    @Override
    public ResponseEntity<CategoryVo> addOrUpdateFile(Long id, MultipartFile file) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        String objectName = "/category/" + id + "_" + LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMddHHmmss"));
        category.setImageId(objectName);
        minioUtil.uploadFile(file, objectName);
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(category)));
    }

    @Override
    public ResponseEntity<CategoryVo> deleteFile(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        category.setImageId(null);
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(category)));
    }

    public CategoryVo getCategoryVo(Category category) throws Exception {
        CategoryVo categoryVo = categoryMapper.toVo(category);
        if(Objects.nonNull(category.getImageId())) {
            minioUtil.getObjectUrl(category.getImageId());
        }
        return categoryVo;
    }
}
