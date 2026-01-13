package io.github.tdminhnhat.core.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationPropertiesScan(basePackages = {
        "io.github.tdminhnhat"
})
@ComponentScan(basePackages = {
        "io.github.tdminhnhat"
})
public class AppConfig {
}
