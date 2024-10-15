package com.glassait.tanks_and_equipments.tanks.overview.controler;

import com.glassait.tanks_and_equipments.api.TanksOverviewApi;
import com.glassait.tanks_and_equipments.api.model.TankOverview;
import com.glassait.tanks_and_equipments.tanks.overview.services.TanksOverviewServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class TanksOverviewController implements TanksOverviewApi {
    private final TanksOverviewServices tanksOverviewServices;

    @Override
    public ResponseEntity<List<TankOverview>> tanksOverview() {
        return new ResponseEntity<>(tanksOverviewServices.getTanksOverview(), HttpStatus.OK);
    }
}
