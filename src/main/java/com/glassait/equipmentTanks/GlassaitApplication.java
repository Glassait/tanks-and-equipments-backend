package com.glassait.equipmentTanks;

import com.glassait.equipmentTanks.config.DataSourceConfigProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties(DataSourceConfigProperties.class)
public class GlassaitApplication {
    public static void main(String[] args) {
        SpringApplication.run(GlassaitApplication.class, args);
        System.out.println("YAHOO, The application is running properly");
    }
}
