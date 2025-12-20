package io.github.tdminhnhat.core.util;

import io.minio.BucketExistsArgs;
import io.minio.MakeBucketArgs;
import io.minio.MinioClient;
import io.minio.errors.MinioException;
import jakarta.annotation.PostConstruct;
import lombok.AccessLevel;
import lombok.experimental.FieldDefaults;

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
        if(bucketName.isEmpty()) {
            throw new MinioException("Bucket name is not configured. Please set 'minio.bucket-name' property.");
        } else if(!minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucketName).build())) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucketName).build());
        }
    }
}
