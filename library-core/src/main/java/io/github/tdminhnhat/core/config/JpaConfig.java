package io.github.tdminhnhat.core.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@Configuration
@EnableJpaAuditing(auditorAwareRef = "autitorAwareImpl")
public class JpaConfig {

    public AuditorAware<String> auditorAwareImpl() {
        return () -> java.util.Optional.of("system");
    }
}
