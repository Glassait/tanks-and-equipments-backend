package com.glassait.lchp.abstracts.tankData;

import com.glassait.lchp.model.tank.FieldsModel;
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
