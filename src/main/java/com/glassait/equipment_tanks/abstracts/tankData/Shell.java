package com.glassait.equipment_tanks.abstracts.tankData;

import com.glassait.equipment_tanks.model.tank.ShellModel;
import lombok.Getter;

@Getter
public class Shell {
    public String name;

    public int amount;

    public boolean premium;

    public Shell(ShellModel shellModel) {
        this.name = shellModel.getName();
        this.amount = shellModel.getAmount();
        this.premium = shellModel.getPremium() == 1;
    }
}
