package com.glassait.equipmentTanks.abstracts.information;

import com.glassait.equipmentTanks.model.information.InformationModel;
import lombok.Getter;

/**
 * This class represent the information/news of the website
 */
@Getter
public class Information {
    /**
     * The text of the information
     */
    private final String text;
    /**
     * The link of the information
     */
    private final InformationLink lien;

    /**
     * The constructor of the class
     *
     * @param informationModel The model get from the database
     */
    public Information(InformationModel informationModel) {
        this.text = informationModel.getText();
        this.lien = informationModel.getUrl() != null ? new InformationLink(informationModel.getUrl(), informationModel.getTextUrl()) : null;
    }
}
