package com.glassait.lchp;

import com.glassait.lchp.config.DataSourceConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataSourceConfigProperties.class)
public class LchpApplication {
    public static void main(String[] args) {
        SpringApplication.run(LchpApplication.class, args);
        System.out.println("YAHOO, The application is running properly");
    }
}
