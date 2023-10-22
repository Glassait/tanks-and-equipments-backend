package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.GlassaitLogger;
import com.glassait.equipmentTanks.abstracts.information.Information;
import com.glassait.equipmentTanks.services.InformationService;
import com.glassait.equipmentTanks.services.WotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller that manage the api for the information of the website
 */
@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class InformationController extends GlassaitLogger {
    /**
     * The instance of the information service
     */
    private final InformationService informationService;
    /**
     * The instance of the wot service
     */
    private final WotService wotService;

    /**
     * Api to get the last information of the website
     *
     * @param accessToken The wot access token of the user
     * @return The last information if the access token is good, else a 401 error
     */
    @GetMapping(value = "api/information")
    public ResponseEntity<Information> getInformation(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            super.logDebug("The access token {" + accessToken + "} is valide");
            return new ResponseEntity<>(this.informationService.getLastInformation(), HttpStatus.OK);
        }
        super.logError("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
