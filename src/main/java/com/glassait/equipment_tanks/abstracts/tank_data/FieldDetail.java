package com.glassait.equipment_tanks.abstracts.tank_data;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class FieldDetail {
    public final String name;
    public final String image;
    public final boolean active;
}
