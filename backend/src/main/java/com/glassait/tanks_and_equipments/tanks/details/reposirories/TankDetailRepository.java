package com.glassait.tanks_and_equipments.tanks.details.reposirories;

import com.glassait.tanks_and_equipments.tanks.details.models.TanksDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankDetailRepository extends JpaRepository<TanksDetailModel, Integer> {
    TanksDetailModel getTankDetailModelById(int id);
}
