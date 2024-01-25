package com.glassait.equipment_tanks.abstracts.tank_data;

import com.glassait.equipment_tanks.model.tank.CrewModel;
import lombok.Getter;

@Getter
public class Crew {
    private final String[] crews;

    public Crew(CrewModel crewModel) {
        this.crews = crewModel.getCrew().split(",");
    }
}
