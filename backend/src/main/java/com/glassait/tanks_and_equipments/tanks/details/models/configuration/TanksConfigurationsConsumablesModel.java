package com.glassait.tanks_and_equipments.tanks.details.models.configuration;

import com.glassait.tanks_and_equipments.tanks.details.models.base.ConsumablesModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tanks_configurations_consumables")
public class TanksConfigurationsConsumablesModel {
    @Id
    @Column(nullable = false)
    @Description("The generated id of the tanks configurations consumable")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = ConsumablesModel.class)
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @NotNull(message = "The configuration consumable cannot be null")
    private ConsumablesModel consumable;
}
