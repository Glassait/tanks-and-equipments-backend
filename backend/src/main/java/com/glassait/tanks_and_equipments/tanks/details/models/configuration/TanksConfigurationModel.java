package com.glassait.tanks_and_equipments.tanks.details.models.configuration;

import com.glassait.tanks_and_equipments.tanks.details.models.base.DirectivesModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Range;

import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tanks_configuration")
@Description("This table hold the information about the equipment/consumable configuration for the tank")
public class TanksConfigurationModel {
    @Id
    @Column(nullable = false)
    @Description("The generated id of the tanks configuration")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Description("The priority of the configuration, 3 = principal, 2 = secondary, 1 = alternatif")
    @Positive(message = "The priority need to be positive and between 1 and 3")
    @Range(min = 1, max = 3, message = "The priority need to be between 1 and 3")
    @NotNull(message = "The priority cannot be null")
    private int priority;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = TanksConfigurationsEquipmentsModel.class)
    @JoinColumn(name = "tank_configuration_id", referencedColumnName = "id", nullable = false)
    @Description("The list of equipment of the configuration")
    @Size(min = 3, max = 3, message = "The list need to contains exactly three items")
    @NotNull(message = "The list cannot be null")
    private List<TanksConfigurationsEquipmentsModel> equipments;

    @ManyToOne(cascade = CascadeType.DETACH, targetEntity = DirectivesModel.class)
    @JoinColumn(nullable = false, referencedColumnName = "id")
    @Description("The directive of the configuration")
    @NotNull(message = "The directive cannot be null")
    private DirectivesModel directive;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = TanksConfigurationsConsumablesModel.class)
    @JoinColumn(name = "tank_configuration_id", referencedColumnName = "id", nullable = false)
    @Description("The list of consumable of the configuration")
    @Size(min = 3, max = 3, message = "The list need to contains exactly three items")
    @NotNull(message = "The list cannot be null")
    private List<TanksConfigurationsConsumablesModel> consumables;
}
