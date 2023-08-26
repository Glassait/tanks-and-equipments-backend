package com.glassait.lchp.services;

import com.glassait.lchp.abstracts.feature.FeatureFlipping;
import com.glassait.lchp.repositories.FeatureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FeatureService {
    @Autowired
    private FeatureRepository featureRepository;

    public FeatureFlipping getAll() {
        return new FeatureFlipping(featureRepository.findAll());
    }
}
