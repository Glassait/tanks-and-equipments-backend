package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.api.InformationApi;
import com.glassait.equipment_tanks.api.model.InformationDto;
import com.glassait.equipment_tanks.services.InformationService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

/**
 * This class is the controller that manages the api for the information of the website
 */
@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class InformationController implements InformationApi {
    /**
     * The service that manages the information of the website
     */
    private final InformationService informationService;
    /**
     * The service that manages the wot api
     */
    private final WotService wotService;

    /**
     * This method is the api to get the last information of the website
     *
     * @param accessToken The wot access token of the user
     * @return The last information if the access token is good, else a 401 error
     */
    @Override
    public ResponseEntity<InformationDto> informations(String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.informationService.getLastInformation(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
