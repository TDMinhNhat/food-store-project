package io.github.tdminhnhat.core.exception.handle;

import io.github.tdminhnhat.core.exception.FileException;
import io.github.tdminhnhat.core.exception.QueryNotFoundException;
import io.minio.errors.MinioException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;

@RestControllerAdvice
public class RestControllerExceptionHandler {

    @ExceptionHandler(QueryNotFoundException.class)
    public ResponseEntity<String> handleQueryNotFoundException(QueryNotFoundException e) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
    }

    @ExceptionHandler(MinioException.class)
    public ResponseEntity<String> handleMinioException(MinioException e) {
        return ResponseEntity.status(HttpStatus.NOT_IMPLEMENTED).body(e.getMessage());
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<List<HashMap<Object, Object>>> handleMethodArgumentNotValidException(MethodArgumentNotValidException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getBindingResult().getAllErrors().stream().map(error -> new HashMap<>(){{
            put("field", error.getObjectName());
            put("message", error.getDefaultMessage());
        }}).toList());
    }

    @ExceptionHandler(FileException.class)
    public ResponseEntity<String> handleFileException(FileException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
    }
}
