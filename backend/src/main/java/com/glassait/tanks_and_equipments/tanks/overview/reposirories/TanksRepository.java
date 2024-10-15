package com.glassait.tanks_and_equipments.tanks.overview.reposirories;

import com.glassait.tanks_and_equipments.tanks.overview.models.TankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TanksRepository extends JpaRepository<TankModel, Integer> {
}
