package com.glassait.tanks_and_equipments.tanks.details.models;

import com.glassait.tanks_and_equipments.tanks.details.models.configuration.FieldsModificationModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksConfigurationModel;
import com.glassait.tanks_and_equipments.tanks.details.models.configuration.TanksCrewMemberModel;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OrderBy;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
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
@Table(name = "tanks_detail")
@Description("This table hold the advanced information for the tanks/detail api")
public class TanksDetailModel {
    @Id
    @Description("The World of Tanks id of the tank")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, length = 1000)
    @Description("The description of the tank")
    @NotBlank(message = "The skill's description must be not blank")
    @NotEmpty(message = "The skill's description must be not empty")
    @NotNull(message = "The skill's description is mandatory")
    private String description;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = TanksCrewMemberModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id", nullable = false)
    private List<TanksCrewMemberModel> crew;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = FieldsModificationModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id", nullable = false)
    @OrderBy("level")
    private List<FieldsModificationModel> fieldsModification;

    @OneToMany(cascade = CascadeType.REMOVE, targetEntity = TanksConfigurationModel.class)
    @JoinColumn(name = "tank_id", referencedColumnName = "id", nullable = false)
    @OrderBy("priority desc")
    private List<TanksConfigurationModel> configurations;
}
