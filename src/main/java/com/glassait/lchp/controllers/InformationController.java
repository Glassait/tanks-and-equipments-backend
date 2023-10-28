package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.information.Information;
import com.glassait.lchp.services.InformationService;
import com.glassait.lchp.services.WotService;
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
public class InformationController {
    private final InformationService informationService;
    private final WotService wotService;

    @GetMapping(value = "api/information")
    public ResponseEntity<Information> getInformation(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.informationService.getLastInformation(), HttpStatus.OK);
        }
        log.warn("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
