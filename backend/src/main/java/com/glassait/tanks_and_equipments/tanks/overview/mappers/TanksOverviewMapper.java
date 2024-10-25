package com.glassait.tanks_and_equipments.tanks.overview.mappers;

import com.glassait.tanks_and_equipments.api.model.TankOverview;
import com.glassait.tanks_and_equipments.api.model.TankOverview.NationEnum;
import com.glassait.tanks_and_equipments.api.model.TankOverview.RoleEnum;
import com.glassait.tanks_and_equipments.api.model.TankOverview.TypeEnum;
import com.glassait.tanks_and_equipments.tanks.overview.models.TankModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TanksOverviewMapper {
    List<TankOverview> convertListTankModelToListTankOverview(List<TankModel> tankModels);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "type", target = "type", qualifiedByName = "convertToTypeEnum")
    @Mapping(source = "level", target = "level")
    @Mapping(source = "role", target = "role", qualifiedByName = "convertToRoleEnum")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "nation", target = "nation", qualifiedByName = "convertToNationEnum")
    @Mapping(source = "isReward", target = "isReward")
    TankOverview convertTankModelToTankOverview(TankModel tankModel);

    @Named("convertToRoleEnum")
    default RoleEnum convertToRoleEnum(String role) {
        return RoleEnum.fromValue(role);
    }

    @Named("convertToTypeEnum")
    default TypeEnum convertToTypeEnum(String type) {
        return TypeEnum.fromValue(type);
    }

    @Named("convertToNationEnum")
    default NationEnum convertToNationEnum(String nation) {
        return NationEnum.fromValue(nation);
    }
}
