package com.glassait.equipment_tanks.abstracts.tank_data;

import com.glassait.equipment_tanks.model.tank.DirectiveModel;
import lombok.Getter;

@Getter
public class Directive {
    private final String name;
    private final String image;

    public Directive(DirectiveModel directiveModel) {
        this.name = directiveModel.getName();
        this.image = directiveModel.getImage();
    }
}
