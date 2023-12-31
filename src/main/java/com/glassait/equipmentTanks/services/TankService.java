package com.glassait.equipmentTanks.services;

import com.glassait.equipmentTanks.abstracts.tankData.Tank;
import com.glassait.equipmentTanks.model.tank.TankModel;
import com.glassait.equipmentTanks.repositories.TankRepository;
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
