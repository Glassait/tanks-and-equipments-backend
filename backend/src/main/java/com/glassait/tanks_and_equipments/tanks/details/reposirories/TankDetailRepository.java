package com.glassait.tanks_and_equipments.tanks.details.reposirories;

import com.glassait.tanks_and_equipments.tanks.details.models.TankDetailModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TankDetailRepository extends JpaRepository<TankDetailModel, Integer> {
    TankDetailModel getTankDetailModelById(int id);
}
