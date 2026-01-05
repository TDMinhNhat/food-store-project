package io.github.tdminhnhat.service.service;

import io.github.tdminhnhat.core.exception.FileException;
import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.github.tdminhnhat.core.model.vo.BaseVo;
import io.github.tdminhnhat.core.service.IService;
import io.github.tdminhnhat.core.util.MinioUtil;
import io.github.tdminhnhat.core.util.ValidateFile;
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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

@Service
@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
@RequiredArgsConstructor
public class CategoryService implements IService<CategoryDto, Long> {

    CategoryRepository categoryRepository;
    CategoryMapper categoryMapper;
    MinioUtil minioUtil;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<CategoryVo> add(CategoryDto request) throws Exception {
        Category category = categoryMapper.toEntity(request);
        if(Objects.nonNull(request.categoryParentId())) {
            category.setCategoryParent(categoryRepository.findById(request.categoryParentId()).orElseThrow(() -> new QueryNotFoundException("Category parent not found")));
        }
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(category)));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<CategoryVo> update(Long id, CategoryDto request) throws Exception {
        Category target = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        Category source = categoryMapper.toEntity(request);
        BeanUtils.copyProperties(source, target, "id", "categoryParentId");
        if(Objects.nonNull(request.categoryParentId())) {
            target.setCategoryParent(categoryRepository.findById(request.categoryParentId()).orElseThrow(() -> new QueryNotFoundException("Category parent not found")));
        } else {
            target.setCategoryParent(null);
        }
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(target)));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<CategoryVo> getById(Long id) throws Exception {
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"))));
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<CategoryVo> delete(Long id) throws Exception {
        Category target = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        target.setDeleted(true);
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(target)));
    }

    @Override
    @Transactional(readOnly = true)
    public ResponseEntity<List<CategoryVo>> getAll() {
        return ResponseEntity.ok(categoryRepository.findAll().stream().map(category -> {
            try {
                return this.getCategoryVo(category);
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).toList());
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<CategoryVo> addOrUpdateFile(Long id, MultipartFile file) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        if(ValidateFile.validateImageFile(file)) {
            String objectName = "/category/" + id + "_" + category.getCategoryName() + "." + Objects.requireNonNull(file.getResource().getFilename()).split("\\.")[1];
            category.setImageId(objectName);
            minioUtil.uploadFile(file, objectName);
            return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(category)));
        } else {
            throw new FileException(FileException.FileExceptionType.FILE_IMAGE_INVALID);
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public ResponseEntity<CategoryVo> deleteFile(Long id) throws Exception {
        Category category = categoryRepository.findById(id).orElseThrow(() -> new QueryNotFoundException("Category not found"));
        category.setImageId(null);
        return ResponseEntity.ok(this.getCategoryVo(categoryRepository.save(category)));
    }

    public CategoryVo getCategoryVo(Category category) throws Exception {
        CategoryVo categoryVo = categoryMapper.toVo(category);
        if(Objects.nonNull(category.getImageId())) {
            categoryVo.setImageUrl(minioUtil.getObjectUrl(category.getImageId()));
        }
        return categoryVo;
    }
}
