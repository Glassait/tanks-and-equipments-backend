package com.glassait.equipment_tanks.mapper;

import com.glassait.equipment_tanks.api.model.Consumables;
import com.glassait.equipment_tanks.api.model.Directive;
import com.glassait.equipment_tanks.api.model.EquipmentDetail;
import com.glassait.equipment_tanks.api.model.Equipments;
import com.glassait.equipment_tanks.api.model.Field;
import com.glassait.equipment_tanks.api.model.FieldDetail;
import com.glassait.equipment_tanks.api.model.Fields;
import com.glassait.equipment_tanks.api.model.Link;
import com.glassait.equipment_tanks.api.model.Shell;
import com.glassait.equipment_tanks.api.model.TankDto;
import com.glassait.equipment_tanks.model.tank.ConsumableModel;
import com.glassait.equipment_tanks.model.tank.CrewModel;
import com.glassait.equipment_tanks.model.tank.DirectiveModel;
import com.glassait.equipment_tanks.model.tank.EquipmentModel;
import com.glassait.equipment_tanks.model.tank.FieldsModel;
import com.glassait.equipment_tanks.model.tank.LinkModel;
import com.glassait.equipment_tanks.model.tank.ShellModel;
import com.glassait.equipment_tanks.model.tank.SkillModel;
import com.glassait.equipment_tanks.model.tank.TankModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.ArrayList;
import java.util.List;

@Mapper(componentModel = "spring")
public interface TanksMapper {
    List<TankDto> convertListTankModelToListTankDto(List<TankModel> models);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "priority", target = "priority")
    @Mapping(source = "crewModel", target = "crew", qualifiedByName = "mapCrew")
    @Mapping(source = "skillModel", target = "skills", qualifiedByName = "mapListSkillModel")
    @Mapping(source = "shellModel", target = "shells", qualifiedByName = "convertListShellModelToListShell")
    @Mapping(source = "fieldsModels", target = "fields", qualifiedByName = "convertListFieldsModelToListFields")
    @Mapping(source = "directiveModel", target = "directive", qualifiedByName = "convertDirectiveModelToDirective")
    @Mapping(source = "equipmentModel", target = "equipments", qualifiedByName = "convertListEquipmentModelToEquipments")
    @Mapping(source = "consumableModel", target = "consumables", qualifiedByName = "convertConsumableModelToConsumables")
    @Mapping(source = "linkModels", target = "links", qualifiedByName = "convertListLinkModelToListLink")
    TankDto convertTankModelToTankDto(TankModel model);

    @Named("mapCrew")
    default List<String> mapCrew(CrewModel model) {
        return List.of(model.getCrew().split(","));
    }

    @Named("mapListSkillModel")
    default List<List<String>> mapListSkillModel(List<SkillModel> models) {
        var arrayList = new ArrayList<List<String>>();
        models.forEach(skillModel -> arrayList.add(mapSkillModel(skillModel)));
        return arrayList;
    }

    @Named("mapSkillModel")
    default List<String> mapSkillModel(SkillModel model) {
        return List.of(model.getSkill().split(","));
    }

    @Named("convertListShellModelToListShell")
    List<Shell> convertListShellModelToListShell(List<ShellModel> models);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "amount", target = "amount")
    @Mapping(target = "premium", expression = "java(model.getPremium() == 1)")
    Shell convertShellModelToShell(ShellModel model);

    @Named("convertListFieldsModelToListFields")
    List<Fields> convertListFieldsModelToListFields(List<FieldsModel> models);

    @Mapping(source = "level", target = "level")
    @Mapping(source = "model", target = "field", qualifiedByName = "convertFieldsModelToField")
    Fields convertFieldsModelToFields(FieldsModel model);

    @Named("convertFieldsModelToField")
    @Mapping(source = "model", target = "left", qualifiedByName = "convertFieldsModelToFieldDetailLeft")
    @Mapping(source = "model", target = "right", qualifiedByName = "convertFieldsModelToFieldDetailRight")
    Field convertFieldsModelToField(FieldsModel model);

    @Named("convertFieldsModelToFieldDetailLeft")
    @Mapping(source = "leftName", target = "name")
    @Mapping(source = "leftImage", target = "image")
    @Mapping(target = "active", expression = "java(model.getLeftActive() == 1)")
    FieldDetail convertFieldsModelToFieldDetailLeft(FieldsModel model);

    @Named("convertFieldsModelToFieldDetailRight")
    @Mapping(source = "rightName", target = "name")
    @Mapping(source = "rightImage", target = "image")
    @Mapping(target = "active", expression = "java(model.getRightActive() == 1)")
    FieldDetail convertFieldsModelToFieldDetailRight(FieldsModel model);

    @Named("convertDirectiveModelToDirective")
    @Mapping(source = "name", target = "name")
    @Mapping(source = "image", target = "image")
    Directive convertDirectiveModelToDirective(DirectiveModel model);

    @Named("convertListEquipmentModelToEquipments")
    default Equipments convertListEquipmentModelToEquipments(List<EquipmentModel> models) {
        var equipments = new Equipments();

        var first = new ArrayList<EquipmentDetail>();
        models.stream().filter(equipmentModel -> equipmentModel.getFirst() == 1).toList().forEach(equipmentModel -> first.add(mapEquipmentDetail(equipmentModel)));
        equipments.first(first);

        var second = new ArrayList<EquipmentDetail>();
        models.stream().filter(equipmentModel -> equipmentModel.getFirst() == 0).toList().forEach(equipmentModel -> second.add(mapEquipmentDetail(equipmentModel)));
        equipments.second(second);

        return equipments;
    }

    default EquipmentDetail mapEquipmentDetail(EquipmentModel model) {
        var equipmentDetail = new EquipmentDetail();

        equipmentDetail.setName(model.getName());
        equipmentDetail.setModernized(model.getModernized() == 1);

        return equipmentDetail;
    }

    @Named("convertConsumableModelToConsumables")
    @Mapping(target = "first", expression = "java(List.of(model.getFirst().split(\",\")))")
    @Mapping(target = "second", expression = "java(List.of(model.getSecond().split(\",\")))")
    Consumables convertConsumableModelToConsumables(ConsumableModel model);

    @Named("convertListLinkModelToListLink")
    List<Link> convertListLinkModelToListLink(List<LinkModel> models);
}
