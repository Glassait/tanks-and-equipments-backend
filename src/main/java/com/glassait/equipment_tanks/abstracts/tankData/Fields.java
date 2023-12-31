package com.glassait.equipment_tanks.abstracts.tankData;

import com.glassait.equipment_tanks.model.tank.FieldsModel;
import lombok.Getter;

@Getter
public class Fields {
    public int level;

    public Field field;

    public Fields(FieldsModel fieldsModel) {
        this.level = fieldsModel.getLevel();
        this.field = new Field(fieldsModel);
    }
}
