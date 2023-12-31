package com.glassait.equipment_tanks.services;

import com.glassait.equipment_tanks.abstracts.tankData.Tank;
import com.glassait.equipment_tanks.model.tank.TankModel;
import com.glassait.equipment_tanks.repositories.TankRepository;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TankService {
    @NonNull
    private TankRepository tankRepository;

    public List<Tank> getTanks() {
        List<TankModel> tankModels = tankRepository.findAll();
        List<Tank> tanks = new ArrayList<>();

        tankModels.forEach(tankModel -> tanks.add(new Tank(tankModel)));

        return tanks;
    }
}
