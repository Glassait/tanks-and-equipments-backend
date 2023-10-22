package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.GlassaitLogger;
import com.glassait.equipmentTanks.abstracts.feature.FeatureFlipping;
import com.glassait.equipmentTanks.services.FeatureService;
import com.glassait.equipmentTanks.services.WotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class FeatureController extends GlassaitLogger {
    /**
     * Instance of the feature service
     */
    private final FeatureService featureService;
    /**
     * Instance of the Wot service
     */
    private final WotService wotService;

    /**
     * Api to get all the feature for the website
     *
     * @param accessToken The WoT access token of the user
     * @return If access token valide all the feature, else 401 error
     */
    @GetMapping(value = "api/feature")
    public ResponseEntity<FeatureFlipping> getAll(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            super.logDebug("The access token {" + accessToken + "} is valide");
            return new ResponseEntity<>(this.featureService.getAll(), HttpStatus.OK);
        }
        super.logError("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
