package com.glassait.equipmentTanks.abstracts.information;

import com.glassait.equipmentTanks.model.information.InformationModel;
import lombok.Getter;

@Getter
public class Information {
    private final String text;
    private final InformationLink lien;

    public Information(InformationModel informationModel) {
        this.text = informationModel.getText();
        this.lien = new InformationLink(informationModel.getUrl(), informationModel.getTextUrl());
    }
}
