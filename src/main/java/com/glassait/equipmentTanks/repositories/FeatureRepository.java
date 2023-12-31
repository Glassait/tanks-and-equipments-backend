package com.glassait.equipmentTanks.repositories;

import com.glassait.equipmentTanks.model.feature.FeatureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<FeatureModel, Integer> {
}
