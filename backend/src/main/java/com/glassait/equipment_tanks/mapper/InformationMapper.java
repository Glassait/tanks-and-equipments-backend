package com.glassait.equipment_tanks.mapper;

import com.glassait.equipment_tanks.api.model.InformationDto;
import com.glassait.equipment_tanks.api.model.InformationLinkDto;
import com.glassait.equipment_tanks.model.information.InformationModel;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface InformationMapper {
    @Mapping(source = "text", target = "text")
    @Mapping(source = "model", target = "link")
    InformationDto convertInformationModelToInformationDto(InformationModel model);

    @Mapping(source = "textUrl", target = "text")
    @Mapping(source = "url", target = "url")
    InformationLinkDto convertInformationModelToInformationLinkDto(InformationModel model);
}
