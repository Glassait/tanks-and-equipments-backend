package com.glassait.equipment_tanks.abstracts.tankData;

import com.glassait.equipment_tanks.model.tank.TankModel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Tank {
    private final String name;
    private final int priority;
    private final String[] crew;
    private final List<List<String>> skills;
    private final List<Shell> shells;
    private final List<Fields> fields;
    private final Directive directive;
    private final Equipments equipments;
    private final Consumables consumables;
    private final List<Link> links;

    public Tank(TankModel tankModel) {
        this.name = tankModel.getName();

        this.priority = tankModel.getPriority();

        this.crew = tankModel.getCrewModel().getCrew().split(",");

        this.skills = new ArrayList<>();
        tankModel.getSkillModel().forEach(skillModel -> this.skills.add(List.of(skillModel.getSkill().split(","))));

        this.shells = new ArrayList<>();
        tankModel.getShellModel().forEach(shellModel -> this.shells.add(new Shell(shellModel)));

        this.fields = new ArrayList<>();
        tankModel.getFieldsModels().forEach(fieldsModel -> this.fields.add(new Fields(fieldsModel)));

        this.directive = new Directive(tankModel.getDirectiveModel());

        this.equipments = new Equipments(
                tankModel.getEquipmentModel().stream().filter(equipmentModel -> equipmentModel.getFirst() == 1).toList(),
                tankModel.getEquipmentModel().stream().filter(equipmentModel -> equipmentModel.getFirst() == 0).toList()
        );

        this.consumables = new Consumables(
                List.of(tankModel.getConsumableModel().getFirst().split(",")),
                List.of(tankModel.getConsumableModel().getSecond().split(","))
        );

        this.links = new ArrayList<>();
        tankModel.getLinkModels().forEach(linkModel -> this.links.add(new Link(linkModel.getName(), linkModel.getUrl())));
    }
}
