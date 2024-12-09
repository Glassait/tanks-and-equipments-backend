package com.glassait.tanks_and_equipments.tanks.details.mappers;

import com.glassait.tanks_and_equipments.api.model.TankDetail;
import com.glassait.tanks_and_equipments.tanks.details.models.TankDetailModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface TanksDetailMapper {
    TankDetail convertTankDetailModelToTankDetail(TankDetailModel tankDetailModel);
}
