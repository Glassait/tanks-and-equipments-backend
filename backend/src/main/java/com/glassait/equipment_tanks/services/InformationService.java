package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.api.model.InformationDto;
import com.glassait.equipment_tanks.mapper.InformationMapper;
import com.glassait.equipment_tanks.repositories.InformationRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

/**
 * This service manage the interaction between the controller and the repository
 */
@Service
@RequiredArgsConstructor
public class InformationService {
    /**
     * Instance of the information repository
     */
    private final InformationRepository informationRepository;
    /**
     * Instance of the information mapper
     */
    private static final InformationMapper INFORMATION_MAPPER = Mappers.getMapper(InformationMapper.class);

    /**
     * Get the last information
     *
     * @return The las information store in the
     */
    public InformationDto getLastInformation() {
        return INFORMATION_MAPPER.convertInformationModelToInformationDto(informationRepository.getLastInformation());
    }
}
