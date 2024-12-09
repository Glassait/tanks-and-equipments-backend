package com.glassait.tanks_and_equipments.shared.events;

import liquibase.exception.LiquibaseException;
import liquibase.integration.spring.SpringLiquibase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@RequiredArgsConstructor
@Slf4j
public class LiquibaseExecutor implements ApplicationListener<ApplicationReadyEvent> {
    private final SpringLiquibase liquibase;

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
        boolean isMock = Arrays.asList(event.getApplicationContext().getEnvironment().getActiveProfiles()).contains("mock");

        String changeLogClasspath = "classpath:./db/changelog/db.changelog-master.yml";
        if (isMock) {
            log.info("Mock profile detected, switch changelog to mock !");
            changeLogClasspath = "classpath:./db/changelog/db.changelog-master-mock.yml";
        }

        try {
            liquibase.setShouldRun(true);
            liquibase.setChangeLog(changeLogClasspath);
            liquibase.afterPropertiesSet();
        } catch (LiquibaseException e) {
            throw new RuntimeException("Failed to execute Liquibase after Jpa with the following error :", e);
        }
    }
}
