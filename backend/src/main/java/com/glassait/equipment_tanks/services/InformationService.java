package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.abstracts.information.Information;
import com.glassait.equipment_tanks.repositories.InformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This service manage the interaction between the controller and the repository
 */
@Service
@RequiredArgsConstructor
public class InformationService {
    /**
     * The instance of the information repository
     */
    private final InformationRepository informationRepository;

    /**
     * Get the last information
     *
     * @return The las information store in the
     */
    public Information getLastInformation() {
        return new Information(informationRepository.getLastInformation());
    }
}
