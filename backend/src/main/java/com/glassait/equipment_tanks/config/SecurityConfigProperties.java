package com.glassait.equipment_tanks.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("spring.security.user")
public record SecurityConfigProperties(String username, String password) {
}
