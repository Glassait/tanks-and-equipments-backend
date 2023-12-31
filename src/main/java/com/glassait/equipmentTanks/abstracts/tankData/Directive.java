package com.glassait.equipmentTanks.abstracts.tankData;

import com.glassait.equipmentTanks.model.tank.DirectiveModel;
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
