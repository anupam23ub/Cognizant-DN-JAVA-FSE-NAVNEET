package com.example.ems.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import java.util.Optional;

/**
 * Exercise 7: Enable JPA auditing and supply the "current auditor".
 *
 * @EnableJpaAuditing activates the @CreatedDate/@LastModifiedDate listeners.
 * The AuditorAware bean tells Spring who the current user is for the
 * @CreatedBy/@LastModifiedBy columns. In a real app this would read from
 * Spring Security; here it returns a fixed system user.
 */
@Configuration
@EnableJpaAuditing
public class AuditingConfig {

    @Bean
    public AuditorAware<String> auditorProvider() {
        // e.g. SecurityContextHolder.getContext().getAuthentication().getName()
        return () -> Optional.of("system-user");
    }
}
