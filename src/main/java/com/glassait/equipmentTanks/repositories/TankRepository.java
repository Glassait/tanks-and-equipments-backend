package com.glassait.equipmentTanks.repositories;

import com.glassait.equipmentTanks.model.tank.TankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankRepository extends JpaRepository<TankModel, Integer> {
}
