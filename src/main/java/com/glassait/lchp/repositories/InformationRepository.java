package com.glassait.lchp.repositories;

import com.glassait.lchp.model.information.InformationModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InformationRepository extends JpaRepository<InformationModel, Integer> {
}
