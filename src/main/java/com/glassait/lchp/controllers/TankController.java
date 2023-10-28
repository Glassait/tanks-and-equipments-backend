package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.tank_data.Tank;
import com.glassait.lchp.services.TankService;
import com.glassait.lchp.services.WotService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RestController
@Slf4j
@RequiredArgsConstructor
public class TankController {
    private final TankService tankService;
    private final WotService wotService;

    @GetMapping(value = "api/tanks")
    public ResponseEntity<List<Tank>> getStudents(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.tankService.getTanks(), HttpStatus.OK);
        }
        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
