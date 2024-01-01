package com.glassait.equipment_tanks.abstracts.information;

import com.glassait.equipment_tanks.model.information.InformationModel;
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

    public Information() {
        this.text = null;
        this.lien = null;
    }

    /**
     * The constructor of the class
     *
     * @param informationModel The model get from the database
     */
    public Information(InformationModel informationModel) {
        this.text = informationModel.getText();
        this.lien = new InformationLink(informationModel.getUrl(), informationModel.getTextUrl());
    }
}
