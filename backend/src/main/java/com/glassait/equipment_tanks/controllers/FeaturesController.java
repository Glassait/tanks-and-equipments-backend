package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.api.FeaturesApi;
import com.glassait.equipment_tanks.api.model.FeatureDto;
import com.glassait.equipment_tanks.api.model.FeatureEnum;
import com.glassait.equipment_tanks.services.FeaturesService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class FeaturesController implements FeaturesApi {
    /**
     * Instance of the feature service
     */
    private final FeaturesService featuresService;
    /**
     * Instance of the Wot service
     */
    private final WotService wotService;

    @Override
    public ResponseEntity<FeatureDto> features(String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.featuresService.getAll(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }

    @Override
    public ResponseEntity<FeatureDto> updateFeatures(String accessToken, String feature) {
        if (this.wotService.checkAccessToken(accessToken)) {
            try {
                return new ResponseEntity<>(this.featuresService.update(FeatureEnum.fromValue(feature).toString()), HttpStatus.OK);
            } catch (IllegalArgumentException e) {
                return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            }
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}
