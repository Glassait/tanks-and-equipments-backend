package com.glassait.lchp;

import com.glassait.lchp.config.DataSourceConfigProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;


@SpringBootApplication
@EnableConfigurationProperties(DataSourceConfigProperties.class)
public class LchpApplication {
    /**
     * The logger for the start application
     */
    private static final Logger logger = LoggerFactory.getLogger(LchpApplication.class);

    public static void main(String[] args) {
        SpringApplication.run(LchpApplication.class, args);
        logger.info("DEBUG -> {}", "YAHOO, The application is running properly");
    }
}
