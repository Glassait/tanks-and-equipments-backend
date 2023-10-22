package com.glassait.lchp.repositories;

import com.glassait.lchp.model.information.InformationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface InformationRepository extends JpaRepository<InformationModel, Integer> {
    @Query("SELECT i FROM InformationModel i ORDER BY i.id DESC LIMIT 1")
    InformationModel getLastInformation();
}
