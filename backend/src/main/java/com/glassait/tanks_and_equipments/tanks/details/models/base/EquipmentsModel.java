package com.glassait.tanks_and_equipments.tanks.details.models.base;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "equipments")
@Description("This table hold all the information for all World of Tanks equipments")
public class EquipmentsModel {
    @Id
    @Column(nullable = false)
    @Description("The generated id of the equipment")
    @Positive(message = "Id must be positive")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @Description("The name of the equipment")
    @NotBlank(message = "The equipment's name must be not blank")
    @NotEmpty(message = "The equipment's name must be not empty")
    @NotNull(message = "The equipment's name is mandatory")
    private String wotName;

    @NotNull(message = "IsModernized field is mandatory")
    @Column(nullable = false)
    private Boolean isModernized = false;
}
