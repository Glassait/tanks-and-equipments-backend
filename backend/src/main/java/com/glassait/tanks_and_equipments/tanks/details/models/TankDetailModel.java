package com.glassait.tanks_and_equipments.tanks.details.models;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jdk.jfr.Description;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "tank_detail")
public class TankDetailModel {
    @Id
    @Description("The id of the tank")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(nullable = false)
    @Description("The description of the tank")
    @NotBlank(message = "The skill's description must be not blank")
    @NotEmpty(message = "The skill's description must be not empty")
    @NotNull(message = "The skill's description is mandatory")
    private String description;
}
