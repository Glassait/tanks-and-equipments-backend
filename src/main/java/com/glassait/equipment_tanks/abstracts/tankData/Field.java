package com.glassait.equipment_tanks.abstracts.tankData;

import com.glassait.equipment_tanks.model.tank.FieldsModel;
import lombok.Getter;

@Getter
public class Field {
    public FieldDetail left;
    public FieldDetail right;

    public Field(FieldsModel fieldsModel) {
        this.left = new FieldDetail(fieldsModel.getLeftName(), fieldsModel.getLeftImage(), fieldsModel.getLeftActive() == 1);
        this.right = new FieldDetail(fieldsModel.getRightName(), fieldsModel.getRightImage(), fieldsModel.getRightActive() == 1);
    }
}
