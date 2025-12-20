package io.github.tdminhnhat.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "auditorAwareImpl")
public class JpaConfig {

    @Bean
    public AuditorAware<String> auditorAwareImpl() {
        return () -> java.util.Optional.of("system");
    }
}
