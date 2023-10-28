package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.GlassaitLogger;
import com.glassait.lchp.abstracts.feature.FeatureFlipping;
import com.glassait.lchp.services.FeatureService;
import com.glassait.lchp.services.WotService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin("*")
@RestController
@RequiredArgsConstructor
public class FeatureController extends GlassaitLogger {
    private final FeatureService featureService;
    private final WotService wotService;

    @GetMapping(value = "api/feature")
    public ResponseEntity<FeatureFlipping> getAll(@RequestParam(name = "access_token") String accessToken) {
        if (this.wotService.checkAccessToken(accessToken)) {
            return new ResponseEntity<>(this.featureService.getAll(), HttpStatus.OK);
        }
        super.logError("The access token {" + accessToken + "} is not valide or the user is not a member of the clan");
        return new ResponseEntity<>(null, HttpStatus.UNAUTHORIZED);
    }
}
