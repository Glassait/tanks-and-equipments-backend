package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.information.Information;
import com.glassait.lchp.services.InformationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RequestMapping(value = "api/information")
@RestController
public class InformationController {
    @Autowired
    private InformationService informationService;

    @GetMapping
    public Information getInformation() {
        return informationService.getLastInformation();
    }
}
