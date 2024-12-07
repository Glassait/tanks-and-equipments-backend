package com.glassait.tanks_and_equipments.tanks.details.services;

import com.glassait.tanks_and_equipments.api.model.TankDetail;
import com.glassait.tanks_and_equipments.config.HazelcastConfig;
import com.glassait.tanks_and_equipments.tanks.details.mappers.TanksDetailMapper;
import com.glassait.tanks_and_equipments.tanks.details.models.TankDetailModel;
import com.glassait.tanks_and_equipments.tanks.details.reposirories.TankDetailRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.mapstruct.factory.Mappers;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@Slf4j
@RequiredArgsConstructor
public class TanksDetailService {
    private static final TanksDetailMapper TANKS_DETAIL_MAPPER = Mappers.getMapper(TanksDetailMapper.class);

    private final TankDetailRepository tankDetailRepository;

    @Cacheable(HazelcastConfig.TANKS_DETAIL_CACHE_KEY)
    public TankDetail getTankDetail(int tankId) {
        TankDetailModel tankDetailModelById = tankDetailRepository.getTankDetailModelById(tankId);
        log.info("{}", tankDetailModelById.toString());
        return TANKS_DETAIL_MAPPER.convertTankDetailModelToTankDetail(tankDetailModelById);
    }
}
