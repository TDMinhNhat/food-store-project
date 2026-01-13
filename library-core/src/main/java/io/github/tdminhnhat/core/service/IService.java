package io.github.tdminhnhat.core.service;

import io.github.tdminhnhat.core.model.qo.BaseQo;
import io.github.tdminhnhat.core.model.vo.BaseVo;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import java.util.Collection;
import java.util.List;

public interface IService<S extends Record, P extends Number> {

    ResponseEntity<? extends BaseVo> add(S request) throws Exception;

    ResponseEntity<? extends BaseVo> update(P id, S request) throws Exception;

    ResponseEntity<? extends BaseVo> getById(P id) throws Exception;

    ResponseEntity<? extends BaseVo> delete(P id) throws Exception;

    <C extends List<BaseVo>> ResponseEntity<C> getAll() throws Exception;

    default <F extends BaseQo> ResponseEntity<Collection<? extends BaseVo>> getAllByFilter(F filter) throws Exception {
        return ResponseEntity.ok(List.of());
    }

    default ResponseEntity<? extends BaseVo> addOrUpdateFile(P id, MultipartFile file) throws Exception {
        return ResponseEntity.ok().build();
    }

    default ResponseEntity<? extends BaseVo> deleteFile(P id) throws Exception {
        return ResponseEntity.ok().build();
    }
}
