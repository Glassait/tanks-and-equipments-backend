package com.glassait.equipment_tanks.repositories;

import com.glassait.equipment_tanks.model.information.InformationModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * This interface represent the SQL interaction with the database
 */
public interface InformationRepository extends JpaRepository<InformationModel, Integer> {
    /**
     * Fetch the last information of the website
     *
     * @return The last information of the website
     */
    @Query("SELECT i FROM InformationModel i ORDER BY i.id DESC LIMIT 1")
    InformationModel getLastInformation();
}
