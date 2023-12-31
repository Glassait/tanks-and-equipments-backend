package com.glassait.equipmentTanks.services;

import com.glassait.equipmentTanks.abstracts.information.Information;
import com.glassait.equipmentTanks.model.information.InformationModel;
import com.glassait.equipmentTanks.repositories.InformationRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class InformationService {
    @NonNull
    private InformationRepository informationRepository;

    public Information getLastInformation() {
        List<InformationModel> informationModels = informationRepository.findAll();

        return new Information(informationModels.get(informationModels.size() - 1));
    }
}
