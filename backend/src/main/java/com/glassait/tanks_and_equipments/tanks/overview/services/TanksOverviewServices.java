package com.glassait.tanks_and_equipments.tanks.overview.services;

import com.glassait.tanks_and_equipments.api.model.TankOverview;
import com.glassait.tanks_and_equipments.shared.configs.HazelcastConfig;
import com.glassait.tanks_and_equipments.tanks.overview.mappers.TanksOverviewMapper;
import com.glassait.tanks_and_equipments.tanks.overview.reposirories.TanksRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TanksOverviewServices {
    private static final TanksOverviewMapper TANKS_OVERVIEW_MAPPER = Mappers.getMapper(TanksOverviewMapper.class);

    private final TanksRepository tanksRepository;

    @Cacheable(HazelcastConfig.TANKS_OVERVIEW_CACHE_KEY)
    public List<TankOverview> getTanksOverview() {
        return TANKS_OVERVIEW_MAPPER.convertListTankModelToListTankOverview(tanksRepository.findAll());
    }
}
