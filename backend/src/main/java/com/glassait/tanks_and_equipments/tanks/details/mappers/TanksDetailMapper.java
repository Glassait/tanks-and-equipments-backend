package com.glassait.tanks_and_equipments.tanks.details.mappers;

import com.glassait.tanks_and_equipments.api.model.Equipment;
import com.glassait.tanks_and_equipments.api.model.ModelConfiguration;
import com.glassait.tanks_and_equipments.api.model.TankDetail;
import com.glassait.tanks_and_equipments.tanks.details.models.EquipmentModel;
import com.glassait.tanks_and_equipments.tanks.details.models.TankConfigurationModel;
import com.glassait.tanks_and_equipments.tanks.details.models.TankDetailModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TanksDetailMapper {

    TankDetail convertTankDetailModelToTankDetail(TankDetailModel tankDetailModel);

    List<ModelConfiguration> convertModelConfigurationListToModelConfigurationList(List<TankConfigurationModel> tankConfigurationModels);

    ModelConfiguration convertModelConfigurationModelToModelConfiguration(TankConfigurationModel modelConfiguration);

    List<Equipment> convertEquipmentListToEquipmentList(List<EquipmentModel> equipmentModels);

    @Mapping(source = "name", target = "name", qualifiedByName = "convertToNameEnum")
    Equipment convertEquipmentModelToEquipment(EquipmentModel equipmentModel);


    @Named("convertToNameEnum")
    default Equipment.NameEnum convertToNameEnum(String name) {
        return Equipment.NameEnum.fromValue(name);
    }
}
