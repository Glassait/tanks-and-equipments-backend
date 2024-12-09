package com.glassait.tanks_and_equipments.shared.contributors;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.actuate.info.Info;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class CustomInfoContributor implements InfoContributor {
    @Value("${info.app.version}")
    private String applicationVersion;

    @Value("${spring.application.name}")
    private String applicationName;


    @Override
    public void contribute(Info.Builder builder) {
        builder.withDetail("app", Map.of("version", applicationVersion, "name", applicationName));
    }
}
