package com.example.ems.config;

import com.zaxxer.hikari.HikariDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.sql.DataSource;

/**
 * Exercise 9: Customizing Data Source Configuration / Managing multiple data
 * sources.
 *
 * Spring Boot auto-configures the PRIMARY data source from the
 * `spring.datasource.*` properties (see application.properties) - that is the
 * "auto-configuration" half of the exercise.
 *
 * This class shows how to add a SECOND, externally configured data source.
 * It is gated behind the "multi-ds" profile so the default single-database run
 * is unaffected. Activate it with:
 *
 *     mvn spring-boot:run -Dspring-boot.run.profiles=multi-ds
 *
 * and provide the `app.secondary.datasource.*` keys
 * (see application-multi-ds.properties).
 */
@Configuration
@Profile("multi-ds")
public class SecondaryDataSourceConfig {

    @Bean
    @ConfigurationProperties(prefix = "app.secondary.datasource")
    public DataSource secondaryDataSource() {
        return DataSourceBuilder.create()
                .type(HikariDataSource.class)
                .build();
    }
}
