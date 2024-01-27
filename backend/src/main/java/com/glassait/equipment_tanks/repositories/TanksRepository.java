package com.glassait.equipment_tanks.repositories;

import com.glassait.equipment_tanks.model.tank.TankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TanksRepository extends JpaRepository<TankModel, Integer> {
    /**
     * Fetch the last information of the website
     *
     * @return The last information of the website
     */
    @Query("SELECT t FROM TankModel t WHERE t.meta = 1 ORDER BY t.priority DESC")
    List<TankModel> getMeta();
}
