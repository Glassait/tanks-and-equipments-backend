package com.glassait.tanks_and_equipments;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Main class of the Glassait application.
 *
 * @author Glassait
 */
@SpringBootApplication
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
