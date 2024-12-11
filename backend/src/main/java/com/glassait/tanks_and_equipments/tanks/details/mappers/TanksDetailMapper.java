package com.glassait.tanks_and_equipments.tanks.details.mappers;

import com.glassait.tanks_and_equipments.api.model.Field;
import com.glassait.tanks_and_equipments.api.model.FieldRow;
import com.glassait.tanks_and_equipments.api.model.TankDetail;
import com.glassait.tanks_and_equipments.tanks.details.models.TanksDetailModel;
import com.glassait.tanks_and_equipments.tanks.details.models.base.FieldsModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.FieldsModificationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TanksDetailMapper {
    TankDetail convertTankDetailModelToTankDetail(TanksDetailModel tanksDetailModel);


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
