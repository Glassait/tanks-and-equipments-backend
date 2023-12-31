package com.glassait.equipment_tanks.abstracts.tankData;

import com.glassait.equipment_tanks.model.tank.DirectiveModel;
import lombok.Getter;

@Getter
public class Directive {
    public String name;

    public String image;

    public Directive(DirectiveModel directiveModel) {
        this.name = directiveModel.getName();
        this.image = directiveModel.getImage();
    }
}
