package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.feature.FeatureFlipping;
import com.glassait.equipmentTanks.services.FeatureService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping(value = "api/feature")
@RestController
@RequiredArgsConstructor
public class FeatureController {
    @NonNull
    private FeatureService featureService;

    @GetMapping
    public FeatureFlipping getAll() {
        return featureService.getAll();
    }
}
