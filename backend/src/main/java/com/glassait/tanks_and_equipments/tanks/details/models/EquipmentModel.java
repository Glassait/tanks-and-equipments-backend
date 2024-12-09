package com.glassait.tanks_and_equipments.tanks.details.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jdk.jfr.Description;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "equipment")
public class EquipmentModel {
    @Positive(message = "Id must be positive")
    @Id
    @Column(nullable = false)
    @Description("The id of the equipment")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false, unique = true)
    @Description("The name of the equipment")
    @NotBlank(message = "The equipment's name must be not blank")
    @NotEmpty(message = "The equipment's name must be not empty")
    @NotNull(message = "The equipment's name is mandatory")
    private String name;

    @NotNull(message = "IsModernized field is mandatory")
    @Column(nullable = false)
    private Boolean isModernized = false;
}
