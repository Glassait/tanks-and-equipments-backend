package com.glassait.tanks_and_equipments.wot.news.services;

import com.glassait.tanks_and_equipments.api.model.WotNews;
import com.glassait.tanks_and_equipments.shared.configs.HazelcastConfig;
import com.glassait.tanks_and_equipments.wot.news.mappers.WotNewsMapper;
import com.glassait.tanks_and_equipments.wot.news.repository.WotNewsRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class WotNewsServices {
    private static final WotNewsMapper WOT_NEWS_MAPPER = Mappers.getMapper(WotNewsMapper.class);

    private final WotNewsRepository wotNewsRepository;

    @Cacheable(HazelcastConfig.WOT_NEWS_CACHE_KEY)
    public List<WotNews> getTanksOverview() {
        return WOT_NEWS_MAPPER.convertListWotNewsModelToListWotNews(wotNewsRepository.getLastNews());
    }
}
