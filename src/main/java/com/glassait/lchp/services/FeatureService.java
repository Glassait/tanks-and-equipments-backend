package com.glassait.lchp.services;

import com.glassait.lchp.abstracts.feature.FeatureFlipping;
import com.glassait.lchp.repositories.FeatureRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureService {
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
