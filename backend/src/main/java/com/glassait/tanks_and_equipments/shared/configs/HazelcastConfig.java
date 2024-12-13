package com.glassait.tanks_and_equipments.shared.configs;

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
    public static final String TANKS_DETAIL_CACHE_KEY = "tank-detail";
    public static final String WOT_NEWS_CACHE_KEY = "wot-news";
    public static final String FOLD_RESULTS_CACHE_KEY = "fold-results";

    @Value("${spring.hazelcast.instance-name}")
    private String hazelcastInstanceName;

    @Bean
    public HazelcastInstance hazelcastInstance() {
        Config config = new Config();
        config.setInstanceName(hazelcastInstanceName);

        CacheSimpleConfig tanksOverviewCacheConfig = new CacheSimpleConfig();
        tanksOverviewCacheConfig.setName(TANKS_OVERVIEW_CACHE_KEY);
        tanksOverviewCacheConfig.setBackupCount(1);
        tanksOverviewCacheConfig.setExpiryPolicyFactory(
                FactoryBuilder.factoryOf(new CreatedExpiryPolicy(new Duration(TimeUnit.HOURS, 1))).toString()
        );

        CacheSimpleConfig tankDetailCacheConfig = new CacheSimpleConfig();
        tankDetailCacheConfig.setName(TANKS_OVERVIEW_CACHE_KEY);
        tankDetailCacheConfig.setBackupCount(1);
        tankDetailCacheConfig.setExpiryPolicyFactory(
                FactoryBuilder.factoryOf(new CreatedExpiryPolicy(new Duration(TimeUnit.HOURS, 1))).toString()
        );

        CacheSimpleConfig wotNewsCacheConfig = new CacheSimpleConfig();
        wotNewsCacheConfig.setName(WOT_NEWS_CACHE_KEY);
        wotNewsCacheConfig.setBackupCount(1);
        wotNewsCacheConfig.setExpiryPolicyFactory(
                FactoryBuilder.factoryOf(new CreatedExpiryPolicy(new Duration(TimeUnit.MINUTES, 30))).toString()
        );

        CacheSimpleConfig foldResultServicesCacheConfig = new CacheSimpleConfig();
        foldResultServicesCacheConfig.setName(FOLD_RESULTS_CACHE_KEY);
        foldResultServicesCacheConfig.setBackupCount(1);
        foldResultServicesCacheConfig.setExpiryPolicyFactory(
                FactoryBuilder.factoryOf(new CreatedExpiryPolicy(new Duration(TimeUnit.HOURS, 1))).toString()
        );

        config.addCacheConfig(tanksOverviewCacheConfig);
        config.addCacheConfig(tankDetailCacheConfig);
        config.addCacheConfig(wotNewsCacheConfig);
        config.addCacheConfig(foldResultServicesCacheConfig);

        return Hazelcast.newHazelcastInstance(config);
    }

    @Bean
    public CacheManager cacheManager() {
        return new HazelcastCacheManager(hazelcastInstance());
    }
}
