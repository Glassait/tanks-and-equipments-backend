package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.abstracts.tank_data.Tank;
import com.glassait.equipment_tanks.services.TankService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller manage the api for the tanks
 */
@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class TankController {
    /**
     * Instance of the tank service
     */
    private final TankService tankService;
    /**
     * Instance of the wot service
     */
    private final WotService wotService;

    /**
     * Fetch all the tanks from the service
     *
     * @param accessToken The wot access token of the user
     * @return The list of the tanks if the access token is valide, else a 401 error
     */
    @GetMapping(value = "api/tanks")
    public ResponseEntity<List<Tank>> getTanks(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.tankService.getTanks(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}

