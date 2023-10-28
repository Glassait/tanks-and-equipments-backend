package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.abstracts.information.Information;
import com.glassait.equipment_tanks.services.InformationService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
@RequiredArgsConstructor
public class InformationController {
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
            return new ResponseEntity<>(this.informationService.getLastInformation(), HttpStatus.OK);
        }
        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
