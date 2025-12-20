package io.github.tdminhnhat.core.properties;

import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "minio")
@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
public class MinioProperties {

    String endpoint;

    String accessKey;

    String secretKey;

    String bucketName;
}
