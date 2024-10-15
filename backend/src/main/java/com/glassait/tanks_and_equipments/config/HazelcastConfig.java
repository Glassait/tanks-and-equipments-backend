package com.glassait.tanks_and_equipments.config;

import com.hazelcast.config.CacheSimpleConfig;
import com.hazelcast.config.Config;
import com.hazelcast.core.Hazelcast;
import com.hazelcast.core.HazelcastInstance;
import com.hazelcast.spring.cache.HazelcastCacheManager;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.CacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class HazelcastConfig {
    public static final String TANKS_OVERVIEW_CACHE_KEY = "tanks-overview";

    @Value("${spring.hazelcast.instance-name}")
    private String hazelcastInstanceName;

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName(hazelcastInstanceName);

        CacheSimpleConfig cacheConfig = new CacheSimpleConfig();
        cacheConfig.setName(TANKS_OVERVIEW_CACHE_KEY);
        cacheConfig.setBackupCount(1);

        config.addCacheConfig(cacheConfig);

        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance());
    }
}
