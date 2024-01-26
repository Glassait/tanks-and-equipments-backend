package com.glassait.equipment_tanks.mapper;

import com.glassait.equipment_tanks.api.model.FeatureDto;
import com.glassait.equipment_tanks.api.model.FeatureEnum;
import com.glassait.equipment_tanks.model.feature.FeatureModel;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Objects;

@Mapper(componentModel = "spring")
public interface FeaturesMapper {
    default FeatureDto convertFeaturesModelToFeaturesDto(List<FeatureModel> models) {
        var features = new FeatureDto();

        models.forEach(model -> {
            if (Objects.equals(model.getFeature(), FeatureEnum.CLANWAR.toString())) {
                features.clanWar(model.getActivated() == 1);
            }
        });

        return features;
    }
}
