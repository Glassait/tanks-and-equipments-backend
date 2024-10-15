package com.glassait.tanks_and_equipments.config;

import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfiguration {
    @Value("${spring.hazelcast.instance-name}")
    private String hazelcastInstanceName;

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName(hazelcastInstanceName);
        return Hazelcast.newHazelcastInstance(config);
    }
}
