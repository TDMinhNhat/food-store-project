package io.github.tdminhnhat.core.config;

import io.github.tdminhnhat.core.properties.MinioProperties;
import io.github.tdminhnhat.core.util.MinioUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MinioConfig {

    @Bean
    @ConditionalOnProperty(prefix = "minio", name = {"endpoint","access-key","secret-key","bucket-name"})
    public MinioUtil minioUtil(MinioProperties minioProperties) {
        return new MinioUtil(minioProperties.getEndpoint(), minioProperties.getAccessKey(), minioProperties.getSecretKey(), minioProperties.getBucketName());
    }
}
