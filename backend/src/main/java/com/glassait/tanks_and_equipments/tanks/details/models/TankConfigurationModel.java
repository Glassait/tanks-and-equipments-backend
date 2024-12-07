package com.glassait.tanks_and_equipments.tanks.details.models;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tank_configuration")
public class TankConfigurationModel {
    @Id
    @Description("The generated id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotNull(message = "Equipment list is mandatory in configuration")
    @OneToMany(cascade = { CascadeType.ALL })
    @JoinTable(
            name = "equipments",
            joinColumns = @JoinColumn(name = "tank_configuration_id"),
            inverseJoinColumns = @JoinColumn(name = "equipment_id")
    )
    private List<EquipmentModel> equipments;
}
