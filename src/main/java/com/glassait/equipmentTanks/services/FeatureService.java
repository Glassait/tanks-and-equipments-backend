package com.glassait.equipmentTanks.services;

import com.glassait.equipmentTanks.abstracts.feature.FeatureFlipping;
import com.glassait.equipmentTanks.repositories.FeatureRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FeatureService {
    @NonNull
    private  FeatureRepository featureRepository;

    public FeatureFlipping getAll() {
        return new FeatureFlipping(featureRepository.findAll());
    }
}
