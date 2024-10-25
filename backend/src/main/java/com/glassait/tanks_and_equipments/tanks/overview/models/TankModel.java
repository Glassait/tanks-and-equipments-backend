package com.glassait.tanks_and_equipments.tanks.overview.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import jdk.jfr.Description;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "tanks")
public class TankModel {
    @Id
    @Column(name = "id")
    @Description("The wargaming id of the tank")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The name of the tank")
    @NotBlank(message = "The tank's name must be not blank")
    @NotEmpty(message = "The tank's name must be not empty")
    @NotNull(message = "The tank's name is mandatory")
    private String name;

    @Column(name = "type", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The type of the tank")
    @NotBlank(message = "The tank's type must be not blank")
    @NotEmpty(message = "The tank's type must be not empty")
    @NotNull(message = "The tank's type is mandatory")
    private String type;

    @Column(name = "level", nullable = false)
    @Description("The level of the tank")
    @Min(value = 6)
    @Max(value = 10)
    @NotNull(message = "The tank's level is mandatory")
    private int level;

    @Column(name = "role", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The role of the tank")
    @NotBlank(message = "The tank's role must be not blank")
    @NotEmpty(message = "The tank's role must be not empty")
    @NotNull(message = "The tank's role is mandatory")
    private String role;

    @Column(name = "nation", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The nation of the tank")
    @NotBlank(message = "The tank's nation must be not blank")
    @NotEmpty(message = "The tank's nation must be not empty")
    @NotNull(message = "The tank's nation is mandatory")
    private String nation;

    @Column(name = "priority", nullable = false)
    @Description("The priority of the tank")
    @Min(value = 1)
    @Max(value = 5)
    @NotNull(message = "The tank's priority is mandatory")
    private int priority;

    @Column(name = "is_reward")
    @Description("If the tank is a reward tank")
    private Boolean isReward;
}
