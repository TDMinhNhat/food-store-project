package io.github.tdminhnhat.core.controller;

import io.github.tdminhnhat.core.model.qo.BaseQo;
import io.github.tdminhnhat.core.model.vo.BaseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface IController<S extends Record, P extends Number> {

    ResponseEntity<? extends BaseVo> add(S request);

    ResponseEntity<? extends BaseVo> update(P id, S request);

    ResponseEntity<? extends BaseVo> getById(P id);

    ResponseEntity<? extends BaseVo> delete(P id);

    ResponseEntity<Collection<? extends BaseVo>> getAll();

    default <F extends BaseQo> ResponseEntity<Collection<? extends BaseVo>> getAll(F filter) {
        return ResponseEntity.ok(List.of());
    }

    default ResponseEntity<? extends BaseVo> addImage(P id, MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    default ResponseEntity<? extends BaseVo> updateImage(P id, MultipartFile file) {
        return ResponseEntity.ok().build();
    }

    default ResponseEntity<? extends BaseVo> deleteImage(P id) {
        return ResponseEntity.ok().build();
    }
}
