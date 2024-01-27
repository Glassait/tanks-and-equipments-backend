package com.glassait.equipment_tanks;

import com.glassait.equipment_tanks.config.DataSourceConfigProperties;
import com.glassait.equipment_tanks.config.GlassaitConfigProperties;
import com.glassait.equipment_tanks.config.SecurityConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Main class of the Glassait application.
 *
 * @author Glassait
 */
@SpringBootApplication
@EnableConfigurationProperties({ DataSourceConfigProperties.class, SecurityConfigProperties.class, GlassaitConfigProperties.class })
@EnableScheduling
@Slf4j
public class GlassaitApplication {
    /**
     * Main method of the application.
     *
     * @param args command line arguments
     */
    public static void main(String[] args) {
        SpringApplication.run(GlassaitApplication.class, args);
        log.info("YAHOO, The application is running properly");
    }
}
