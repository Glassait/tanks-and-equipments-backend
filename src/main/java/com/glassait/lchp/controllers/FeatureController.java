package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.feature.FeatureFlipping;
import com.glassait.lchp.services.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping(value = "api/feature")
@RestController
public class FeatureController {
    @Autowired
    private FeatureService featureService;

    @GetMapping
    public FeatureFlipping getAll() {
        return featureService.getAll();
    }
}
