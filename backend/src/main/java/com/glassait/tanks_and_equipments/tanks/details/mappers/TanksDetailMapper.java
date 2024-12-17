package com.glassait.tanks_and_equipments.tanks.details.mappers;

import com.glassait.tanks_and_equipments.api.model.Consumable;
import com.glassait.tanks_and_equipments.api.model.CrewMember;
import com.glassait.tanks_and_equipments.api.model.Directive;
import com.glassait.tanks_and_equipments.api.model.Equipment;
import com.glassait.tanks_and_equipments.api.model.Field;
import com.glassait.tanks_and_equipments.api.model.FieldRow;
import com.glassait.tanks_and_equipments.api.model.ModelConfiguration;
import com.glassait.tanks_and_equipments.api.model.Skill;
import com.glassait.tanks_and_equipments.api.model.TankDetail;
import com.glassait.tanks_and_equipments.tanks.details.models.TanksDetailModel;
import com.glassait.tanks_and_equipments.tanks.details.models.base.DirectivesModel;
import com.glassait.tanks_and_equipments.tanks.details.models.base.FieldsModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.FieldsModificationModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksConfigurationModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksConfigurationsConsumablesModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksConfigurationsEquipmentsModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksCrewMemberModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksCrewSecondaryRolesModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksCrewsSkillsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TanksDetailMapper {
    @Mapping(source = "configurations", target = "configurations")
    TankDetail convertTankDetailModelToTankDetail(TanksDetailModel tanksDetailModel);

    List<ModelConfiguration> convertListTanksConfigurationModelToListModelConfiguration(List<TanksConfigurationModel> tanksConfigurationModels);

    @Mapping(source = "priority", target = "priority", qualifiedByName = "convertToPriorityEnum")
    ModelConfiguration convertTankConfigurationModelToModelConfiguration(TanksConfigurationModel tanksConfigurationModel);

    @Mapping(source = "equipment.name", target = "name")
    @Mapping(source = "equipment.wotName", target = "wotName", qualifiedByName = "convertToEquipmentWotNameEnum")
    @Mapping(source = "equipment.isModernized", target = "isModernized")
    Equipment tanksConfigurationsEquipmentsModelToEquipment(TanksConfigurationsEquipmentsModel tanksConfigurationsEquipmentsModel);

    @Mapping(source = "wotName", target = "wotName", qualifiedByName = "convertToDirectiveWotNameEnum")
    Directive directivesModelToDirective(DirectivesModel directivesModel);

    @Named("convertToDirectiveWotNameEnum")
    default Directive.WotNameEnum convertToDirectiveWotNameEnum(String name) {
        return Directive.WotNameEnum.fromValue(name);
    }

    @Named("convertToEquipmentWotNameEnum")
    default Equipment.WotNameEnum convertToEquipmentWotNameEnum(String name) {
        return Equipment.WotNameEnum.fromValue(name);
    }

    @Mapping(source = "consumable.name", target = "name")
    @Mapping(source = "consumable.wotName", target = "wotName", qualifiedByName = "convertToConsumableWotNameEnum")
    Consumable tanksConfigurationsConsumablesModelToConsumable(TanksConfigurationsConsumablesModel tanksConfigurationsConsumablesModel);

    @Named("convertToConsumableWotNameEnum")
    default Consumable.WotNameEnum convertToConsumableWotNameEnum(String name) {
        return Consumable.WotNameEnum.fromValue(name);
    }

    @Named("convertToPriorityEnum")
    default ModelConfiguration.PriorityEnum convertToPriorityEnum(int priority) {
        if (priority == 3) {
            return ModelConfiguration.PriorityEnum.PRINCIPAL;
        } else if (priority == 2) {
            return ModelConfiguration.PriorityEnum.SECONDAIRE;
        }

        return ModelConfiguration.PriorityEnum.ALTERNATIF;
    }

    @Mapping(source = "role.wotName", target = "name")
    CrewMember tanksCrewMemberModelToCrewMember(TanksCrewMemberModel tanksCrewMemberModel);

    @Mapping(source = "role.wotName", target = "name")
    CrewMember tanksCrewSecondaryRolesModelToCrewMember(TanksCrewSecondaryRolesModel tanksCrewSecondaryRolesModel);

    @Mapping(source = "skill.name", target = "name")
    @Mapping(source = "skill.wotName", target = "wotName", qualifiedByName = "convertToSkillNameEnum")
    Skill tanksCrewsSkillsModelToSkill(TanksCrewsSkillsModel tanksCrewsSkillsModel);

    @Named("convertToSkillNameEnum")
    default Skill.WotNameEnum convertToSkillNameEnum(String skill) {
        return Skill.WotNameEnum.fromValue(skill);
    }

    List<FieldRow> convertListFieldsModificationModelToListFieldRow(List<FieldsModificationModel> fieldsModificationModel);

    @Mapping(target = "left", expression = "java(convertToField(fieldsModificationModel.getLeftField(), \"left\".equals(fieldsModificationModel.getActiveSide()), fieldsModificationModel.getNames().get(0)))")
    @Mapping(target = "right", expression = "java(convertToField(fieldsModificationModel.getRightField(), \"right\".equals(fieldsModificationModel.getActiveSide()), fieldsModificationModel.getNames().get(1)))")
    FieldRow convertFieldsModificationModelToFieldRow(FieldsModificationModel fieldsModificationModel);

    @Named("convertToField")
    default Field convertToField(FieldsModel fieldsModel, boolean isActive, String name) {
        Field field = new Field();

        field.wotName(Field.WotNameEnum.fromValue(fieldsModel.getWotName()));
        field.name(name);
        field.isActive(isActive);

        return field;
    }
}
