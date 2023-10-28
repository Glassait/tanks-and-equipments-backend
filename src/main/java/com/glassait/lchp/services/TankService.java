package com.glassait.lchp.services;

import com.glassait.lchp.abstracts.tank_data.Tank;
import com.glassait.lchp.model.tank.TankModel;
import com.glassait.lchp.repositories.TankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class TankService {
    private final TankRepository tankRepository;

    /**
     * Get all the tanks data from the database
     *
     * @return The list of tanks data
     */
    public List<Tank> getTanks() {
        List<TankModel> tankModels = tankRepository.findAll();
        List<Tank> tanks = new ArrayList<>();

        tankModels.forEach(tankModel -> tanks.add(new Tank(tankModel)));

        return tanks;
    }
}
