package com.glassait.lchp.repositories;

import com.glassait.lchp.model.feature.FeatureModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureRepository extends JpaRepository<FeatureModel, Integer> {
}
