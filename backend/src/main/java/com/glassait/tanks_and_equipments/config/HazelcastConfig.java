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

import javax.cache.configuration.FactoryBuilder;
import javax.cache.expiry.CreatedExpiryPolicy;
import javax.cache.expiry.Duration;
import java.util.concurrent.TimeUnit;

@Configuration
public class HazelcastConfig {
    public static final String TANKS_OVERVIEW_CACHE_KEY = "tanks-overview";
    public static final String WOT_NEWS_CACHE_KEY = "wot-news";

    @Value("${spring.hazelcast.instance-name}")
    private String hazelcastInstanceName;

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName(hazelcastInstanceName);

        CacheSimpleConfig tankOverviewCacheConfig = new CacheSimpleConfig();
        tankOverviewCacheConfig.setName(TANKS_OVERVIEW_CACHE_KEY);
        tankOverviewCacheConfig.setBackupCount(1);
        tankOverviewCacheConfig.setExpiryPolicyFactory(
                FactoryBuilder.factoryOf(new CreatedExpiryPolicy(new Duration(TimeUnit.HOURS, 1))).toString()
        );

        CacheSimpleConfig wotNewsCacheConfig = new CacheSimpleConfig();
        wotNewsCacheConfig.setName(WOT_NEWS_CACHE_KEY);
        wotNewsCacheConfig.setBackupCount(1);
        wotNewsCacheConfig.setExpiryPolicyFactory(
                FactoryBuilder.factoryOf(new CreatedExpiryPolicy(new Duration(TimeUnit.MINUTES, 30))).toString()
        );

        config.addCacheConfig(tankOverviewCacheConfig);
        config.addCacheConfig(wotNewsCacheConfig);

        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance());
    }
}
