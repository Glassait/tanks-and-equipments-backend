package com.glassait.lchp.services;

import com.glassait.lchp.abstracts.information.Information;
import com.glassait.lchp.repositories.InformationRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InformationService {
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
