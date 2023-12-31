package com.glassait.equipmentTanks.controllers;

import com.glassait.equipmentTanks.abstracts.tankData.Tank;
import com.glassait.equipmentTanks.services.TankService;
import com.glassait.equipmentTanks.services.WotService;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "api/tanks/{access_token}")
@RestController
@RequiredArgsConstructor
public class TankController {
    @NonNull
    private TankService tankService;
    @NonNull
    private WotService wotService;

    @GetMapping
    public List<Tank> getStudents(@PathVariable("access_token") String accessToken) {
        if (wotService.checkAccessToken(accessToken)) {
            return tankService.getTanks();
        }
        System.out.println("Token : `" + accessToken + "` is invalid or has expire");
        return null;
    }
}
