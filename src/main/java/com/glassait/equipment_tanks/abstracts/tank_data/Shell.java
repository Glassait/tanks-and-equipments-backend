package com.glassait.equipment_tanks.abstracts.tank_data;

import com.glassait.equipment_tanks.model.tank.ShellModel;
import lombok.Getter;

@Getter
public class Shell {
    private final String name;
    private final int amount;
    private final boolean premium;

    public Shell(ShellModel shellModel) {
        this.name = shellModel.getName();
        this.amount = shellModel.getAmount();
        this.premium = shellModel.getPremium() == 1;
    }
}
