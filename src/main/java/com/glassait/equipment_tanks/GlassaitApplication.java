package com.glassait.equipment_tanks;

import com.glassait.equipment_tanks.config.DataSourceConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;

@SpringBootApplication
@EnableConfigurationProperties(DataSourceConfigProperties.class)
@EnableMethodSecurity
public class GlassaitApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlassaitApplication.class, args);
        System.out.println("YAHOO, The application is running properly");
    }
}
