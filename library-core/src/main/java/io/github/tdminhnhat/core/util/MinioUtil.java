package io.github.tdminhnhat.core.util;

import io.minio.*;
import io.minio.errors.MinioException;
import io.minio.http.Method;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;
import org.springframework.web.multipart.MultipartFile;

import java.util.concurrent.TimeUnit;

@FieldDefaults(level = AccessLevel.PRIVATE, makeFinal = true)
public class MinioUtil {

    MinioClient minioClient;
    String bucketName;

    public MinioUtil(String endpoint, String accessKey, String secretKey, String bucketName) {
        this.minioClient = MinioClient.builder()
                .endpoint(endpoint)
                .credentials(accessKey, secretKey).build();
        this.bucketName = bucketName;
    }

    @PostConstruct
    public void initService() throws Exception {
        if (bucketName.isEmpty()) {
            throw new MinioException("Bucket name is not configured. Please set 'minio.bucket-name' property.");
        } else if (!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }

    public void uploadFile(MultipartFile file, String objectName) throws Exception {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucketName).object(objectName).contentType(file.getContentType()).stream(file.getInputStream(), file.getSize(), -1).build());
    }

    public void deleteFile(String objectName) throws Exception {
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucketName).object(objectName).build());
    }

    public String getObjectUrl(String objectName) throws Exception {
        return minioClient.getPresignedObjectUrl(GetPresignedObjectUrlArgs.builder().method(Method.GET).bucket(bucketName).object(objectName).expiry(24, TimeUnit.HOURS).build());
    }
}
