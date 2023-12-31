package com.glassait.equipmentTanks.abstracts.tankData;

import com.glassait.equipmentTanks.model.tank.EquipmentModel;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Equipments {
    public List<EquipmentDetail> first;

    public List<EquipmentDetail> second;

    public Equipments(List<EquipmentModel> equipmentModelFirst, List<EquipmentModel> equipmentModelSecond) {
        this.first = new ArrayList<>();
        equipmentModelFirst.forEach(equipmentModel -> this.first.add(new EquipmentDetail(equipmentModel.getName(), equipmentModel.getModernized() == 1)));

        this.second = new ArrayList<>();
        equipmentModelSecond.forEach(equipmentModel -> this.second.add(new EquipmentDetail(equipmentModel.getName(), equipmentModel.getModernized() == 1)));
    }
}
