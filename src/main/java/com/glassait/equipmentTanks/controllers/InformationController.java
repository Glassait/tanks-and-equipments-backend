package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.information.Information;
import com.glassait.equipmentTanks.services.InformationService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping(value = "api/information")
@RestController
@RequiredArgsConstructor
public class InformationController {
    @NonNull
    private InformationService informationService;

    @GetMapping
    public Information getInformation() {
        return informationService.getLastInformation();
    }
}
