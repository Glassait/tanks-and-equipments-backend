package com.glassait.tanks_and_equipments.wot.news.controllers;

import com.glassait.tanks_and_equipments.api.WotNewsApi;
import com.glassait.tanks_and_equipments.api.model.WotNews;
import com.glassait.tanks_and_equipments.wot.news.services.WotNewsServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class WotNewsController implements WotNewsApi {
    private final WotNewsServices wotNewsServices;

    @Override
    public ResponseEntity<List<WotNews>> wotNews() {
        return new ResponseEntity<>(wotNewsServices.getTanksOverview(), HttpStatus.OK);
    }
}
