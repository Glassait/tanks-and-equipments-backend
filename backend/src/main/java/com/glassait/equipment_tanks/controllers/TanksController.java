package com.glassait.equipment_tanks.controllers;

import com.glassait.equipment_tanks.api.TanksApi;
import com.glassait.equipment_tanks.api.model.TankDto;
import com.glassait.equipment_tanks.services.TanksService;
import com.glassait.equipment_tanks.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * This controller manage the api for the tanks
 */
@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class TanksController implements TanksApi {
    /**
     * Instance of the tank service
     */
    private final TanksService tanksService;
    /**
     * Instance of the wot service
     */
    private final WotService wotService;

    @Override
    public ResponseEntity<List<TankDto>> tanks(String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.tanksService.getTanks(), HttpStatus.OK);
        }

        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
    }
}

