package com.glassait.lchp.abstracts.tank_data;

import com.glassait.lchp.model.tank.FieldsModel;
import lombok.Getter;

@Getter
public class Fields {
    private final int level;
    private final Field field;

    public Fields(FieldsModel fieldsModel) {
        this.level = fieldsModel.getLevel();
        this.field = new Field(fieldsModel);
    }
}
