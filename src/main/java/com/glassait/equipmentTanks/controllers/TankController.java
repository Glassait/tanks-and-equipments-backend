package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.GlassaitLogger;
import com.glassait.equipmentTanks.abstracts.tankData.Tank;
import com.glassait.equipmentTanks.services.TankService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
@RequiredArgsConstructor
public class TankController extends GlassaitLogger {
    /**
     * The instance of the tank service
     */
    private final TankService tankService;

    /**
     * Fetch all the tanks from the service
     *
     * @param accessToken The wot access token of the user
     * @return The list of the tanks if the access token is valide, else a 401 error
     */
    @GetMapping(value = "api/tanks")
    @PreAuthorize("wotService.checkAccessToken(accessToken)")
    public ResponseEntity<List<Tank>> getTanks(@RequestParam(name = "access_token") String accessToken) {
        super.logDebug("The access token {" + accessToken + "} is valide");
        return new ResponseEntity<>(this.tankService.getTanks(), HttpStatus.OK);
    }
}

