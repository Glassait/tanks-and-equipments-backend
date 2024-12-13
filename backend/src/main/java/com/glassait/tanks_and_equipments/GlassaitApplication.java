package com.glassait.tanks_and_equipments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@Slf4j
@SpringBootApplication(exclude = { SecurityAutoConfiguration.class })
@EnableWebSecurity
@EnableCaching
public class GlassaitApplication {
    public static void main(String[] args) {
        var env = SpringApplication.run(GlassaitApplication.class, args).getEnvironment();
        String logString = """
                \n|==================================================
                |\tL'application '{}' à correctement démaré
                |
                |\tUrl : http://localhost:{}
                |\tProfiles : {}
                |==================================================
                """;
        log.info(logString, env.getProperty("spring.application.name"), env.getProperty("server.port"), env.getActiveProfiles());
    }
}
