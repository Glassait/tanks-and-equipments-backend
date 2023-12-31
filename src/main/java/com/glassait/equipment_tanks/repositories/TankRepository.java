package com.glassait.equipment_tanks.repositories;

import com.glassait.equipment_tanks.model.tank.TankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankRepository extends JpaRepository<TankModel, Integer> {
}
