package com.glassait.equipmentTanks.abstracts.feature;

import com.glassait.equipmentTanks.model.feature.FeatureModel;
import lombok.Getter;

import java.util.List;

@Getter
public class FeatureFlipping {
    private final boolean clanWar;

    public FeatureFlipping(List<FeatureModel> featureModel) {
        this.clanWar = featureModel.get(0).getActivated() == 1;
    }
}
