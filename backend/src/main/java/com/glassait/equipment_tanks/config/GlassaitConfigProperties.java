package com.glassait.equipment_tanks.config;

import org.springframework.boot.context.properties.ConfigurationProperties;

@ConfigurationProperties("glassait")
public record GlassaitConfigProperties(String clan_id) {
}
