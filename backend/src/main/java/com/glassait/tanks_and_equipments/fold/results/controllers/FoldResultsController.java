package com.glassait.tanks_and_equipments.fold.results.controllers;

import com.glassait.tanks_and_equipments.api.FoldResultApi;
import com.glassait.tanks_and_equipments.api.model.FoldResult;
import com.glassait.tanks_and_equipments.fold.results.services.FoldResultServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class FoldResultsController implements FoldResultApi {
    private final FoldResultServices foldResultServices;

    @Override
    public ResponseEntity<List<FoldResult>> foldResult() {
        return new ResponseEntity<>(foldResultServices.getTanksOverview(), HttpStatus.OK);
    }
}
