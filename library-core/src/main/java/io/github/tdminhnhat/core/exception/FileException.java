package io.github.tdminhnhat.core.exception;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.experimental.FieldDefaults;

public class FileException extends RuntimeException {

    public FileException(FileExceptionType type) {
        super(type.getMessage());
    }

    @Getter
    @FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
    @AllArgsConstructor
    public enum FileExceptionType {

        FILE_IMAGE_INVALID("Must be content-type is image file. Allowed types: jpg, png"),
        FILE_ICON_INVALID("Must be content-type is icon file. Allowed types: ico");

        String message;
    }
}
