package com.glassait.lchp.services;

import com.glassait.lchp.abstracts.information.Information;
import com.glassait.lchp.model.information.InformationModel;
import com.glassait.lchp.repositories.InformationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InformationService {
    @Autowired
    private InformationRepository informationRepository;

    public Information getLastInformation() {
        List<InformationModel> informationModels = informationRepository.findAll();

        return new Information(informationModels.get(informationModels.size() - 1));
    }
}
