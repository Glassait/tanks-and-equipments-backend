package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.api.model.TankDto;
import com.glassait.equipment_tanks.mapper.TanksMapper;
import com.glassait.equipment_tanks.repositories.TanksRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TanksService {
    /**
     * Instance of tanks repository
     */
    private final TanksRepository tanksRepository;

    /**
     * Instance of tanks mapper
     */
    private static final TanksMapper TANKS_MAPPER = Mappers.getMapper(TanksMapper.class);

    /**
     * Get all the tanks data from the database
     *
     * @return The list of tanks data
     */
    public List<TankDto> getTanks() {
        return TANKS_MAPPER.convertListTankModelToListTankDto(tanksRepository.getMeta());
    }
}
