package com.glassait.equipment_tanks.repositories;

import com.glassait.equipment_tanks.model.feature.FeatureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<FeatureModel, Integer> {
    FeatureModel findByFeature(String name);
}
