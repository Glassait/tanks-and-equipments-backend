package com.glassait.lchp;

import com.glassait.lchp.config.DataSourceConfigProperties;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.scheduling.annotation.EnableScheduling;


@SpringBootApplication
@EnableConfigurationProperties(DataSourceConfigProperties.class)
@EnableScheduling
@Slf4j
public class LchpApplication {

    public static void main(String[] args) {
        SpringApplication.run(LchpApplication.class, args);
        log.info("YAHOO, The application is running properly");
    }
}
