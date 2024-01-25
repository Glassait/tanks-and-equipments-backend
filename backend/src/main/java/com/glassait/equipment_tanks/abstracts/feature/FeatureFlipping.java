package com.glassait.equipment_tanks.abstracts.feature;

import com.glassait.equipment_tanks.model.feature.FeatureModel;
import lombok.Getter;

import java.util.List;

@Getter
public class FeatureFlipping {
    private final Boolean clanWar;

    public FeatureFlipping(List<FeatureModel> featureModel) {
        this.clanWar = featureModel.get(0).getActivated() == 1;
    }
}
