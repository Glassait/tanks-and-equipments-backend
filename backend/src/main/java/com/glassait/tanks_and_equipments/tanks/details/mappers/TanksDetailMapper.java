package com.glassait.tanks_and_equipments.tanks.details.mappers;

import com.glassait.tanks_and_equipments.api.model.CrewMember;
import com.glassait.tanks_and_equipments.api.model.Field;
import com.glassait.tanks_and_equipments.api.model.FieldRow;
import com.glassait.tanks_and_equipments.api.model.Skill;
import com.glassait.tanks_and_equipments.api.model.TankDetail;
import com.glassait.tanks_and_equipments.tanks.details.models.TanksDetailModel;
import com.glassait.tanks_and_equipments.tanks.details.models.base.FieldsModel;
import com.glassait.tanks_and_equipments.tanks.details.models.base.SkillsModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.FieldsModificationModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksCrewMemberModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksCrewSecondaryRolesModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksCrewsSkillsModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TanksDetailMapper {
    TankDetail convertTankDetailModelToTankDetail(TanksDetailModel tanksDetailModel);

    @Mapping(source = "role.wotName", target = "name")
    CrewMember tanksCrewMemberModelToCrewMember(TanksCrewMemberModel tanksCrewMemberModel);

    @Mapping(source = "role.wotName", target = "name")
    CrewMember tanksCrewSecondaryRolesModelToCrewMember(TanksCrewSecondaryRolesModel tanksCrewSecondaryRolesModel);

    @Mapping(source = "skill", target = "name", qualifiedByName = "convertToSkillNameEnum")
    Skill tanksCrewsSkillsModelToSkill(TanksCrewsSkillsModel tanksCrewsSkillsModel);

    @Named("convertToSkillNameEnum")
    default Skill.NameEnum convertToSkillNameEnum(SkillsModel skill) {
        return Skill.NameEnum.fromValue(skill.getWotName());
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
