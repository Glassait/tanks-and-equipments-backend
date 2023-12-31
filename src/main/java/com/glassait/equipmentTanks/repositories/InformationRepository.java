package com.glassait.equipmentTanks.repositories;

import com.glassait.equipmentTanks.model.information.InformationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationModel, Integer> {
}
