package io.github.tdminhnhat.core.util;

import org.springframework.web.multipart.MultipartFile;

public class ValidateFile {

    public static boolean validateImageFile(MultipartFile file) {
        String contentType = file.getContentType();
        if (contentType == null) {
            return false;
        }
        return contentType.equals("image/jpeg") ||
               contentType.equals("image/png");
    }
}
