package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.abstracts.feature.FeatureFlipping;
import com.glassait.equipment_tanks.repositories.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * This service interact with the database to manage the feature
 */
@Service
@RequiredArgsConstructor
public class FeatureService {
    /**
     * The instance of the feature repository
     */
    private final FeatureRepository featureRepository;

    /**
     * Get all the features
     *
     * @return All the features with there status
     */
    public FeatureFlipping getAll() {
        return new FeatureFlipping(featureRepository.findAll());
    }
}
