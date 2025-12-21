package io.github.tdminhnhat.core.config;

import io.github.tdminhnhat.core.properties.MinioProperties;
import io.github.tdminhnhat.core.util.MinioUtil;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
@ConditionalOnProperty(prefix = "minio", name = {"endpoint","access-key","secret-key","bucket-name"})
public class MinioConfig {

    @Bean
    @Primary
    public MinioUtil minioUtil(MinioProperties minioProperties) {
        return new MinioUtil(minioProperties.getEndpoint(), minioProperties.getAccessKey(), minioProperties.getSecretKey(), minioProperties.getBucketName());
    }
}
