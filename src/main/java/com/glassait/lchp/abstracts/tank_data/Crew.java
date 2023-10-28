package com.glassait.lchp.abstracts.tank_data;

import com.glassait.lchp.model.tank.CrewModel;
import lombok.Getter;

@Getter
public class Crew {
    private final String[] crews;

    public Crew(CrewModel crewModel) {
        this.crews = crewModel.getCrew().split(",");
    }
}
