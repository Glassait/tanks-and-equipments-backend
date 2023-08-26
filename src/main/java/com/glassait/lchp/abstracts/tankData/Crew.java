package com.glassait.lchp.abstracts.tankData;

import com.glassait.lchp.model.tank.CrewModel;
import lombok.Getter;

@Getter
public class Crew {
    private final String[] crew;

    public Crew(CrewModel crewModel) {
        this.crew = crewModel.getCrew().split(",");
    }
}
