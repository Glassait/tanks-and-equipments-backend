package com.glassait.tanks_and_equipments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Slf4j
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableWebSecurity
public class GlassaitApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlassaitApplication.class, args);
        log.info("YAHOO, The application is running properly");
    }
}
