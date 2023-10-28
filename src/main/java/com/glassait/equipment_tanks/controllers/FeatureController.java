package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.abstracts.feature.FeatureFlipping;
import com.glassait.equipment_tanks.services.FeatureService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class FeatureController {
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
        if (accessToken != null && !accessToken.isEmpty() && this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.featureService.getAll(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
