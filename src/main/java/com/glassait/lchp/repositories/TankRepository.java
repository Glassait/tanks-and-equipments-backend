package com.glassait.lchp.repositories;

import com.glassait.lchp.model.tank.TankModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankRepository extends JpaRepository<TankModel, Integer> {
}
