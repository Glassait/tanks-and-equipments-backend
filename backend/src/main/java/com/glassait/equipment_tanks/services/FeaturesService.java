package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.api.model.FeatureDto;
import com.glassait.equipment_tanks.mapper.FeaturesMapper;
import com.glassait.equipment_tanks.repositories.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

/**
 * This service interact with the database to manage the feature
 */
@Service
@RequiredArgsConstructor
public class FeaturesService {
    /**
     * Instance of the feature repository
     */
    private final FeatureRepository featureRepository;
    /**
     * Instance of the feature mapper
     */
    private  static final FeaturesMapper FEATURES_MAPPER = Mappers.getMapper(FeaturesMapper.class);

    /**
     * Get all the features
     *
     * @return All the features with there status
     */
    public FeatureDto getAll() {
        return FEATURES_MAPPER.convertFeaturesModelToFeaturesDto(featureRepository.findAll());
    }

    /**
     * Change the activated part of the given feature
     *
     * @param featureName The name of the feature
     * @return All the features with there status
     */
    public FeatureDto update(String featureName) {
        var feature = featureRepository.findByFeature(featureName);
        feature.setActivated(feature.getActivated() == 0 ? 1 : 0);
        featureRepository.saveAndFlush(feature);

        return FEATURES_MAPPER.convertFeaturesModelToFeaturesDto(featureRepository.findAll());
    }
}
