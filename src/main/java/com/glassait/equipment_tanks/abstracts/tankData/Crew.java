package com.glassait.equipment_tanks.abstracts.tankData;

import com.glassait.equipment_tanks.model.tank.CrewModel;
import lombok.Getter;

@Getter
public class Crew {
    private final String[] crew;

    public Crew(CrewModel crewModel) {
        this.crew = crewModel.getCrew().split(",");
    }
}
