package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.tankData.Tank;
import com.glassait.lchp.services.TankService;
import com.glassait.lchp.services.WotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin("*")
@RequestMapping(value = "api/tanks/{access_token}")
@RestController
public class TankController {
    @Autowired
    private TankService tankService;
    @Autowired
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
