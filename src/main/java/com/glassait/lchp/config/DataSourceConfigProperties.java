package com.glassait.lchp.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.datasource")
public record DataSourceConfigProperties(String url, String username, String password) {
}
