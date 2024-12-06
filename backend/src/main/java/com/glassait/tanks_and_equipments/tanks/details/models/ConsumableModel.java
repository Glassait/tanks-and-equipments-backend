package com.glassait.tanks_and_equipments.tanks.details.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
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
@Table(name = "consumable")
public class ConsumableModel {
    @Id
    @Column(name = "id")
    @Description("The id of the consumable")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name", nullable = false)
    @Size(min = 5, max = 100)
    @Description("The name of the consumable")
    @NotBlank(message = "The consumable's name must be not blank")
    @NotEmpty(message = "The consumable's name must be not empty")
    @NotNull(message = "The consumable's name is mandatory")
    private String name;
}
