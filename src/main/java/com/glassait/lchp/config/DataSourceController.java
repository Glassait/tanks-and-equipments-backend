package com.glassait.lchp.config;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/test")
public class DataSourceController {

    private final DataSourceConfigProperties dataSourceConfigProperties;

    public DataSourceController(DataSourceConfigProperties dataSourceConfigProperties) {
        this.dataSourceConfigProperties = dataSourceConfigProperties;
    }

    @GetMapping
    public Map<String, String> printAllProps() {
        return Map.of("url", dataSourceConfigProperties.url(), "username", dataSourceConfigProperties.username(), "password", dataSourceConfigProperties.password());
    }
}
