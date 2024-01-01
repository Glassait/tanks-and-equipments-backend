package com.glassait.equipment_tanks.abstracts.tank_data;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Consumables {
    private List<String> first;
    private List<String> second;
}
