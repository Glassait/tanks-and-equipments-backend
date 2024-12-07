package com.glassait.tanks_and_equipments.tanks.details.controler;

import com.glassait.tanks_and_equipments.api.TanksDetailApi;
import com.glassait.tanks_and_equipments.api.model.TankDetail;
import com.glassait.tanks_and_equipments.tanks.details.services.TanksDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

@Controller
@RequiredArgsConstructor
public class TanksDetailController implements TanksDetailApi {
    private final TanksDetailService tanksDetailService;

    @Override
    public ResponseEntity<TankDetail> tanksDetail(Integer tankId) {
        TankDetail tankDetail = tanksDetailService.getTankDetail(tankId);

        if (tankDetail == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(tankDetail, HttpStatus.OK);
    }
}
