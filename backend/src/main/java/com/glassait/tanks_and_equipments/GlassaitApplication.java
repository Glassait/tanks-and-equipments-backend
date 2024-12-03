package com.glassait.tanks_and_equipments;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Slf4j
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableWebSecurity
@EnableCaching
@RequiredArgsConstructor
public class GlassaitApplication {
    private final Environment environment;

    public static void main(String[] args) {
        SpringApplication.run(GlassaitApplication.class, args);
        log.info("""
                \n==================================================
                L'application à correctement démaré
                
                Url :
                Profiles :
                ==================================================
                """);
    }
}
