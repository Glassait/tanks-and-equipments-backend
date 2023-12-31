package com.glassait.equipmentTanks.abstracts.tankData;

import com.glassait.equipmentTanks.model.tank.CrewModel;
import lombok.Getter;

@Getter
public class Crew {
    private final String[] crew;

    public Crew(CrewModel crewModel) {
        this.crew = crewModel.getCrew().split(",");
    }
}
