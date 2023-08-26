package com.glassait.lchp.controllers;

import com.glassait.lchp.abstracts.tankData.Tank;
import com.glassait.lchp.services.TankService;
import com.glassait.lchp.services.UserService;
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
    private UserService userService;

    @GetMapping
    public List<Tank> getStudents(@PathVariable("access_token") String accessToken) {
        if (userService.checkAccessToken(accessToken)) {
            return tankService.getTanks();
        }
        System.out.println("Token : `" + accessToken + "` is invalid or has expire");
        return null;
    }
}
